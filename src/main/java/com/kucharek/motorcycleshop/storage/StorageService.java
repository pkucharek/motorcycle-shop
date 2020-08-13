package com.kucharek.motorcycleshop.storage;


import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    void init();

    void store(MultipartFile file, String offerId);

    Stream<Path> loadAll();

    Path load(String offerId, String filename);

    Resource loadAsResource(String offerId, String filename);

    void deleteAll();

}
