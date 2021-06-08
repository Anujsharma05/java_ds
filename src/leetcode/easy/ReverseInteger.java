package leetcode.easy;

public class ReverseInteger {

	public static void main(String[] args) {
		int input = -123;
		
		int output = reverse(input);
		System.err.println(output);
	}

	//O(log10(n))
	public static int reverse(int x) {
        
		int left = (int) Math.pow(-2, 31);
		int right = (int) (Math.pow(2, 31) - 1);
		
//		boolean isNegative = false;
		
		System.err.println(left == Integer.MIN_VALUE);
		System.err.println(right == Integer.MAX_VALUE);
//		if(x < 0) {
//			x = x * -1;
//			isNegative = true;
//		}
		
		int sum = 0;
		
		while(x != 0) {
			int r = x%10;
			int result = sum*10 + r;
			
			//calculating 'sum' in line 28 by adjusting lhs rhs to verify for overflow
			if((result - r)/10 != sum) {
				return 0;
			}
			sum = result;
			x = x/10;
		}
		
//		if(isNegative) {
//			sum = sum * -1;
//		}
		
//		if(left <= sum && sum < right) {
//			return sum;
//		}
		
		if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
			return 0;
		}
		return sum;
    }
}
