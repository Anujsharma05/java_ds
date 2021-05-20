package sorting;

public class SelectionSort {

	public static void main(String[] args) {
		
		int arr[] = {5, 2, -1, 6, 3};
		int n = arr.length;
		for(int i=0; i<n-1; i++) {
			int minIndex = i;
			boolean sorted = true;
			for(int j=i+1; j<n; j++) {
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
					sorted = false;
				}
			}
			if(!sorted) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
			for(int a: arr) {
				System.err.print(a + " ");
			}
			System.err.println();
		}
		
//		for(int a: arr) {
//			System.err.print(a + " ");
//		}
//		
	}

}
