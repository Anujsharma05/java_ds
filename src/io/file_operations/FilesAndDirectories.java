package io.file_operations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesAndDirectories {

  public static void main(String[] args) {
//    createTemporaryDirectory();
//    createTemporaryFile();
    createRegularDirectoryAndFile();
  }

  private static Path getCurrentPackagePath() {
    Path currentPackage = Path.of("./io/file_operations");
    return currentPackage;
  }

  private static Path createTemporaryDirectory() {
    try {
      Path dir = Files.createTempDirectory(getCurrentPackagePath(), "mytempdir");
      System.out.println(dir);
      return dir;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void createTemporaryFile() {

    Path dir = createTemporaryDirectory();

    try {
      Path file = Files.createTempFile(dir, "mytemp", ".txt");
      System.out.println(file);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  private static void createRegularDirectoryAndFile() {

    Path curPackage = getCurrentPackagePath();

    try {

      Path dirToBeCreated = curPackage.resolve("demo_dir");

      if(Files.exists(dirToBeCreated)) {
        System.out.println("directory already exist");
        return;
      }

      Path dir = Files.createDirectory(dirToBeCreated);

      Path file = Files.createFile(dir.resolve("demo.txt"));

      System.out.println(file);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
