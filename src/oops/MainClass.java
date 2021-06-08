package oops;

public class MainClass {

	public static void main(String[] args) {
		
		int nums[] = {-1, 3 -2};
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		for(int i=0; i<nums.length; i++) {
			
			sum = sum + nums[i];
			
			if(max < sum) {
				max = sum;
				System.err.println(max);
			}
			
			if(sum < 0) {
				sum = 0;
			}
		}
		
		System.err.println(max);
	}

}
