package sorting;

public class BubbleSort {

	public static void main(String[] args) {

		int arr[] = {1 , 5 ,3 ,2};
		int temp;
		int count=0;
		int n = arr.length;
		for(int i=0; i<n-1; i++) {
			
			boolean sorted = true;
			
			for(int j=0; j<n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					sorted = false;
				}
			}
			count++;
			if(sorted) break;
			
		}
		System.err.println(count);
		for(int i: arr) {
			System.err.print(i + " ");
		}
	}
}
