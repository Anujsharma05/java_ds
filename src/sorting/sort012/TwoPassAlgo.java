package sorting.sort012;

import java.util.Arrays;

public class TwoPassAlgo {
	//Two Iterations hence two pass
	public static void main(String[] args) {
		
		int[] arr = {2,2,2};
		arr = sort012(arr);
		System.err.println(Arrays.toString(arr));
	}

	private static int[] sort012(int[] arr) {
		
		int count0=0, count1=0;
		
		for(int i: arr) {
			if(i==0) count0++;
			else if(i==1) count1++;
		}
//		int count=0;
//		for(int i=0; i<arr.length; i++) {
//			if(count<count0) {
//				arr[i]=0;
//			} else if(count < count0+count1) {
//				arr[i]=1;
//			} else {
//				arr[i] = 2;
//			}
//			count++;
//		}
		for(int i=0; i<arr.length; i++) {
			if(count0 > 0) {
				arr[i] = 0;
				count0--;
			} else if(count1 > 0) {
				arr[i] = 1;
				count1--;
			} else {
				arr[i] = 2;
			}
		}
		
		return arr;
	}
}
