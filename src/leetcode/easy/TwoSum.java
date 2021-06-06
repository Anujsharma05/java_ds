package leetcode;

public class TwoSum {

	public static void main(String[] args) {
		
		int nums[] = {3, 2, 5};
		int target = 5;
		
		int output[]  = twoSumOutput(nums, target);
		
		for(int i: output) {
			System.err.print(i + " ");
		}

	}
	
	public static int[] twoSumOutput(int nums[], int target) {
		
		int output[] = new int[2];
		int n = nums.length;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(nums[i] + nums[j] == target) {
					output[0] = i;
					output[1] = j;
					break;
				}
			}
		}
		
		return output;
	}

}
