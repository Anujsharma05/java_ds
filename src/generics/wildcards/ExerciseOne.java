package generics.wildcards;

import java.util.ArrayList;
import java.util.List;
public class ExerciseOne {
    public <T> void copy(List<? extends T> source, List<? super T> destination) {
        for(T t: source) {
            destination.add(t);
        }
    }
    public static void main(String[] args) {
        ExerciseOne obj = new ExerciseOne();
        List<String> source = new ArrayList<>();
        source.add("one");
        source.add("two");
        source.add("three");
        List<String> destination = new ArrayList<>();
        obj.copy(source, destination);
        System.out.println(destination);
    }
}
