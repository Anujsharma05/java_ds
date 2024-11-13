package io.file_operations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteInFile {

  public static void main(String[] args) throws IOException {

    Path path = Path.of("./io/file_operations");

    Path dir = Files.createDirectory(path.resolve("demo"));

    Path file = Files.createFile(dir.resolve("hello.txt"));

    String str = "This is Sparta";

//    wayOne(file, str);
//    wayTwo(file, str);
//    wayThree(file, str);
    wayFour(file, str);
  }

  static void wayOne(Path file, String str) throws IOException {
    Path p = Files.writeString(file, str);
    System.out.println(p);
  }

  /**
   * Here using for String
   * But it should be used for binary data, directly dealing with bytes
   */
  static void wayTwo(Path file, String str) throws IOException {

    Files.write(file, str.getBytes(StandardCharsets.UTF_8));
  }

  static void wayThree(Path file, String str) {

    try(OutputStream outputStream = Files.newOutputStream(file)) {

      outputStream.write(str.getBytes(StandardCharsets.UTF_8));

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  static void wayFour(Path file, String str) {

    try(BufferedWriter bufferedWriter = Files.newBufferedWriter(file)) {

      bufferedWriter.write(str);

    } catch(IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
