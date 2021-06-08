package geeksforgeeks.school;

import java.util.ArrayList;

public class ValueIndexEqual {

public static void main(String[] args) {
		
		int arr[] = {1};
		int n = arr.length;
		ArrayList<Integer> output = getSecondLargest(arr, n);
		
		for(Integer i: output) {
			System.err.println(i + " ");
		}
	}

	private static ArrayList<Integer> getSecondLargest(int[] arr, int n) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			if(arr[i] == i+1) {
				list.add(arr[i]);
			}
		}
		return list;
	}
}
