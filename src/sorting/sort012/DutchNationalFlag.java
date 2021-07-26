package sorting.sort012;

import java.util.Arrays;
// we are taking low and high as pivots. 0's lie before low, 2's lie after high, 1's lie in between. That's why with 1 there is no swap as it acts as pivot between 0 and 2
public class DutchNationalFlag {
	//Only one iteration
	public static void main(String[] args) {
		int[] arr = {2,2,2};
		arr = sort012(arr);
		System.err.println(Arrays.toString(arr));
	}

	private static int[] sort012(int[] arr) {
		
		int low=0, mid=0;
		int high=arr.length-1;
		
		while(mid<=high) {
			
			if(arr[mid]==0) {
				int temp = arr[mid];
				arr[mid] = arr[low];
				arr[low] = temp;
				
				mid++;
				low++;
			} else if(arr[mid] == 1) {
				mid++;
			} else {
				int temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				
				high--;
			}
		}
		return arr;
	}

}
