package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise {
    public static void main(String[] args) {
        Exercise e = new Exercise();
        e.runExercise();
        int[][] arr = new int[3][];
        System.out.println(Arrays.deepToString(arr));
    }
    public void runExercise() {
        Library<Algorithm> library = new Library<>();
        library.add(new SearchAlgorithm());
        library.add(new SortingAlgorithm());
        library.add(new GraphAlgorithm());

        Algorithm item = library.getLast();

        while(item!=null) {
            item.execute();
            item = library.getLast();
        }
    }
}

class Library<T extends Algorithm> {
    static List<Algorithm> algorithms;
    public void add(T algorithm) {
        if(algorithms == null) {
            algorithms = new ArrayList<>();
        }
        algorithms.add(algorithm);
    }
    public Algorithm getLast() {
        return algorithms.isEmpty() ? null : algorithms.get(algorithms.size()-1);
    }

    public static void execute(Algorithm algorithm) {
        algorithms.removeIf(algo -> algo == algorithm);
    }
}
interface Algorithm {
    void execute();
}

class SearchAlgorithm implements Algorithm {
    @Override
    public void execute() {
        System.out.println("execute search");
        Library.execute(this);
    }
}

class SortingAlgorithm implements Algorithm {
    @Override
    public void execute() {
        System.out.println("execute sort");
        Library.execute(this);
    }
}
class GraphAlgorithm implements Algorithm {
    @Override
    public void execute() {
        System.out.println("execute graph");
        Library.execute(this);
    }
}


