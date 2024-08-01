package java_eight.assignments;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Assignment2 {
  public static void main(String[] args) {
    staticMR();
  }
  static void staticMR() {
    List<Integer> inputList = Arrays.asList(1,2,7,4,5);
    Consumer<List<Integer>> sort = list -> Collections.sort(list);
    sort.accept(inputList);
    System.out.println(inputList);

    inputList = Arrays.asList(1,2,7,4,5);

    System.out.println(inputList);

    Consumer<List<Integer>> methodRef = Collections::sort;
  }
}
