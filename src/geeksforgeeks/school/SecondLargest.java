package geeksforgeeks.school;

public class SecondLargest {

	public static void main(String[] args) {
		
		int arr[] = {10, 5, 1};
		int n = arr.length;
		System.err.println(Integer.MIN_VALUE);
		int output = getSecondLargest(arr, n);
		
		System.err.println(output);
	}

	private static int getSecondLargest(int[] arr, int n) {
		
		int secondLargest = arr[0];
		int largest = arr[0];
		
		if(n < 2) {
			return -1;
		} else {
			for(int i=1; i<n ; i++) {
				
				if(arr[i] == secondLargest) {
					continue;
				} else if(arr[i] > secondLargest && arr[i] > largest) {
					secondLargest = largest;
					largest = arr[i];
				} else if(arr[i] < largest && arr[i] < secondLargest && largest == secondLargest){
					secondLargest = arr[i];
				} else if(arr[i] < largest && arr[i] > secondLargest) {
					secondLargest = arr[i];
				}
			}
			
			if(largest == secondLargest) {
				return -1;
			} else {
				return secondLargest;
			}
		}
		
	}

}
