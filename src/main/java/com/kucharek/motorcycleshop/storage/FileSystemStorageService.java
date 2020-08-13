package com.kucharek.motorcycleshop.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
public class FileSystemStorageService implements StorageService {

    private final Path rootLocation;

    @Autowired
    public FileSystemStorageService() {
        this.rootLocation = Paths.get("upload-dir");
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
            String[] directoriesToCopy = {"1", "2", "3", "4", "5"};
            for (String directory : directoriesToCopy) {
                Path src = Paths.get("_images").resolve(directory);
                Path dest = rootLocation.resolve(directory);
                try (Stream<Path> stream = Files.walk(src)) {
                    stream.forEach(source -> copy(source, dest.resolve(src.relativize(source))));
                }
            }
        }
        catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    private void copy(Path source, Path dest) {
        try {
            Files.copy(source, dest, REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public void store(MultipartFile file, String offerId) {
        String filename = StringUtils.cleanPath(
                Objects.requireNonNull(file.getOriginalFilename())
        );
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            Path offerImagePath = rootLocation.resolve(offerId).resolve(filename);
            Path offerImagePathDirectory = offerImagePath.getParent();
            Files.createDirectories(offerImagePathDirectory);
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, offerImagePath,
                        REPLACE_EXISTING
                );
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(this.rootLocation::relativize);
        }
        catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }
    }

    @Override
    public Path load(String offerId, String filename) {
        return rootLocation.resolve(offerId).resolve(filename);
    }

    @Override
    public Resource loadAsResource(String offerId, String filename) {
        try {
            Path file = load(offerId, filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);

            }
        }
        catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
}
