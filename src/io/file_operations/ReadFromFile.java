package io.file_operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ReadFromFile {

  public static void main(String[] args) throws IOException {
    Path dir = Path.of("./io/file_operations/test_files");

    Path file = dir.resolve("test.txt");

//    wayOne(file);
//    wayTwo(file);
//    wayThree(file);
//    wayFour(file);
    wayFive(file);
  }

  static void wayOne(Path file) throws IOException {
    String str = Files.readString(file);
    System.out.println(str);
  }

  static void wayTwo(Path file) throws IOException {
    byte[] bytes = Files.readAllBytes(file);
    String str = new String(bytes);
    System.out.println(str);
  }

  static void wayThree(Path file) {

    try(InputStream inputStream = Files.newInputStream(file)) {
      byte[] bytes = inputStream.readAllBytes();
      String str = new String(bytes);
      System.out.println(str);
    } catch(IOException ex)  {
      System.out.println(ex.getMessage());
    }
  }

  static void wayFour(Path file) {

    try(BufferedReader bufferedReader = Files.newBufferedReader(file)) {

      String line;
      while((line = bufferedReader.readLine()) != null) {
        if(line.isBlank()) continue;
        System.out.println(line);
      }
    } catch(IOException ex)  {
      System.out.println(ex.getMessage());
    }
  }

  static void wayFive(Path file)  {

    try(Stream<String> lines = Files.lines(file)) {

      lines.forEach(System.out::println);

    } catch(IOException ex)  {
      throw new RuntimeException(ex);
    }
  }
}
