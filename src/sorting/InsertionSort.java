package sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		arr = sort(arr);
		System.out.print(Arrays.toString(arr));
	}

	private static int[] sort(int[] arr) {
		
		if(arr.length < 2) return arr;
		
		for(int i=1; i<arr.length; i++) {
			boolean swapped = false;
			int temp = arr[i];
			for(int j=i-1; j>=0; j--) {
				if(arr[j]>temp) {
					arr[j+1] = arr[j];
				} else {
					arr[j+1] = temp;
					swapped = true;
					break;
				}
			}
			if(!swapped) {
				arr[0] = temp;
			}
		}
		
		return arr;
	}
}
