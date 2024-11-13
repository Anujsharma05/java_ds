package io.file_operations;

import java.net.URI;
import java.nio.file.Path;

public class PathCreate {

  public static void main(String[] args) {
//    differentWaysToCreatePath();
//    getAbsolutePathFromRelativePath();
//    getRelativePathFromAbsolutePath();
    createPathUsingURI();
  }

  public static void differentWaysToCreatePath() {
    Path path1 = Path.of("./", "src", "tmp").resolve("hello.txt");
    System.out.println(path1);

    Path path2 = Path.of("./", "src", "tmp", "hello.txt");
    System.out.println(path2);

    Path path3 = Path.of("./src/tmp/hello.txt");
    System.out.println(path3);
  }

  public static void getRelativePathFromAbsolutePath() {
    Path absolutePath = Path.of("D:\\Coding\\Codebase\\Java\\java_ds\\src\\io\\file_operations");
    Path relativeFrom = Path.of("D:\\Coding\\Codebase\\Java\\java_ds");
    System.out.println(relativeFrom.relativize(absolutePath));
  }

  public static void getAbsolutePathFromRelativePath() {
    Path path = Path.of("./io/file_operations");
    System.out.println(path.toAbsolutePath());
    /**
     * To remove the '.' which is given in input for the relative current base dir
     */
    System.out.println(path.normalize().toAbsolutePath());
  }

  /**
   * URI needs file scheme to work. Example:
   *
   * "http://" for web pages
   * "https://" for secure web pages
   * "ftp://" for FTP resources
   * "file://" for files on a local or network file system
   */
  public static void createPathUsingURI() {
    Path path = Path.of(URI.create("file:///D:/Coding/Codebase/Java/java_ds/src/io/file_operations"));
    System.out.println(path);
  }

}
