package comparing;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1, 55f);
        Student s2 = new Student(2, 82f);
        Student s3 = new Student(3, 62f);
        Student s4 = new Student(4, 32f);
        Student s5 = new Student(5, 42f);

        Student[] arr = {s1, s2, s3, s4, s5 };

        Comparator<Student> comparator = (o1, o2) -> (int) (o1.marks - o2.marks);

        Arrays.sort(arr, comparator);

        System.out.println(Arrays.toString(arr));
    }
}
