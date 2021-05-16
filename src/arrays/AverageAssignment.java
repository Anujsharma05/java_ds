package arrays;

import java.util.Scanner;

public class AverageAssignment {

	public static void main(String[] args) {

		System.err.println("Enter the number of students in class");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] marks = new int[n];
		int total = 0;
		
		System.err.println("Enter marks of each student");
		for(int i=0; i<n; i++) {
			marks[i] = sc.nextInt();
			total = total + marks[i];
		}
		sc.close();
		System.err.println("Average marks: " + (float)total/(float)n);
	}

}
