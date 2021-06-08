package leetcode.easy;

public class BuySellStock {

	public static void main(String[] args) {
		//kadane algo
		
		int[] prices = {};
		int n = prices.length;
		
		if(n ==0 ) {
			System.err.println("return 0");
			//dont execute below
		}
		
		int max = Integer.MIN_VALUE;
		int output = 0;
		int min = prices[0];
		
		for(int i=0; i<n; i++) {
			if(min > prices[i]) {
				min  = prices[i];
			} else {
				output = prices[i] - min;
			}
			
			if(max < output) {
				max = output;
			}
		}
		
		System.err.println(max);
	}

}
