package leetcode;

public class SearchInsertionPosition {

	public static void main(String[] args) {

		int[] nums = { 1,3, 5, 7 };
		int target = 6;

		int output = searchInsert(nums, target);
		System.err.println(output);
	}

	public static int searchInsert(int[] nums, int target) {

		int low = 0;
		int high = nums.length - 1;

		int closeIndex = -1;

		if(target > nums[high]) {
			return high + 1;
		}
		if(target < nums[low]) {
			return low;
		}
		
		while (low <= high) {

			//imp condition start
			if(low == high) {
				return low;
			}
			//imp condition end
			
			int mid = (low + high) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (target > nums[mid]) {
				low = mid + 1;
			} else {
				high = mid -1;
			}
		}

		return closeIndex;
	}
}
