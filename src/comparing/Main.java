package comparing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Student s1 = new Student(1, 32f);
		Student s2 = new Student(2, 82f);
		Student s3 = new Student(3, 62f);
		Student s4 = new Student(4, 44);
		Student s5 = new Student(5, 32f);

		Student[] arr = { s3, s5, s1, s4, s2 };

//		sortUsingComparable(arr);
//		sortUsingComparator(arr);
//		sortUsingLambdaExpression(arr);
		sortUsingCollectionsStaticMethod(arr);

		System.out.println(Arrays.toString(arr));
	}
	private static void sortUsingLambdaExpression(Student[] arr) {
		Comparator<Student> comparator = (st1, st2) -> (int) (st1.marks - st2.marks);
		Arrays.sort(arr, comparator);
	}
	private static void sortUsingCollectionsStaticMethod(Student[] arr) {
		/**
		 * If marks same for two students then sort by role number
		 */
		List<Student> list = Arrays.asList(arr);
		Collections.unmodifiableList(List.of(arr));
		Collections.sort(list, Comparator.comparing(Student::getMarks).thenComparing(Student::getRollNo));

		/**
		 * For Descending order
		 */
//		Collections.sort(list, Comparator.comparing(Student::getMarks).thenComparing(Student::getRollNo).reversed());
	}
	private static void sortUsingComparator(Student[] arr) {
		Comparator<Student> comparator = new Comparator<>() {
			@Override
			public int compare(Student stu1, Student stu2) {
				return stu1.rollNo - stu2.rollNo;
			}
		};

		Arrays.sort(arr, comparator);
	}
	private static void sortUsingComparable(Student[] arr) {
		Arrays.sort(arr);
	}
}
