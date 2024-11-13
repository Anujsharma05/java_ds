package io.file_operations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ListFilesAndFolders {

  public static void main(String[] args) {

    Path dir = Path.of("./io/file_operations");
    printFiles(dir);
  }

  static void printFiles(Path dir) {
    try(Stream<Path> pathStream =  Files.walk(dir)) {
      pathStream.forEach(System.out::println);
    } catch(IOException ex) {
      throw new RuntimeException(ex);
    }
  }

}
