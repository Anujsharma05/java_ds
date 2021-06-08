package leetcode.easy;

public class MaximumSubarray {

	public static void main(String[] args) {
		
		int[] A = {7, 7, -15, 2, 15};
		
		int max = Integer.MIN_VALUE, sum = 0;
	   
		for(int i = 0 ; i<A.length; i++) {
			if(sum < 0) {
				sum = A[i];
			} else {
				sum += A[i];
			}
			
			if(sum > max) {
				max = sum;
			}
		}
		
	    System.err.println(max);

	}

}
