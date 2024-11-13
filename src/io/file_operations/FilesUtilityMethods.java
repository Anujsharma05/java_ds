package io.file_operations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.time.Instant;
import java.util.Set;

public class FilesUtilityMethods {

  public static void main(String[] args) throws IOException {

    Path path = Path.of("./io/file_operations");

    Path curFile = path.resolve("FilesUtilityMethods.java");

    System.out.println(Files.exists(curFile));

    System.out.println(Files.getOwner(curFile));

    System.out.println("Size in bytes:" + Files.size(curFile));

    System.out.println(Files.probeContentType(curFile));

    System.out.println(Files.isDirectory(path));

    System.out.println(Files.isRegularFile(curFile));

    System.out.println(Files.isReadable(curFile) && Files.isWritable(curFile));

    System.out.println(Files.getLastModifiedTime(curFile));

    Path helloFile = path.resolve("test_files").resolve("hello.txt");
    Path worldFile = path.resolve("test_files").resolve("world.txt");
    /**
     * Checks the two file, compare size, also compare the index at which the two files' content differ
     */
    System.out.println(Files.mismatch(helloFile, worldFile));

    /**
     * Does not work in Windows os
     */
//    Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(helloFile);
//    System.out.println(posixFilePermissions);
  }

}
