package io.file_operations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MoveFile {

  public static void main(String[] args) throws IOException {

    Path dir = Path.of("./io/file_operations");
    Path dir1 = Files.createDirectory(dir.resolve("dir1"));
    Path file = Files.createFile(dir1.resolve("hello.txt"));

    Path dir2 = Files.createDirectory(dir.resolve("dir2"));

    /**
     * Passing the same file name as the source folder's file
     */
    Files.move(file, dir2.resolve(file.getFileName()));

  }
}
