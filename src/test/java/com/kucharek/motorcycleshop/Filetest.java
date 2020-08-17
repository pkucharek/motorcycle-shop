package com.kucharek.motorcycleshop;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class Filetest {

    @Test
    public void whenConcatenatePath_shouldReturnPathToImage() {
        Path rootLocation = Paths.get("upload-dir");
        String offerId = "4";
        String fileName = "kawasaki.jpg";
        Path result = rootLocation.resolve(offerId).resolve(fileName);
        assertThat(result.toString()).isEqualTo("upload-dir\\4\\kawasaki.jpg");
        assertThat(result.getParent().toString()).isEqualTo("upload-dir\\4");

    }


}
