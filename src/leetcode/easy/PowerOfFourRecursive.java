package leetcode.easy;

public class PowerOfFourRecursive {

	public static void main(String[] args) {
		double logValue = Math.log(24)/Math.log(4);
		System.err.println(logValue%1);
		PowerOfFour obj = new PowerOfFour();
		boolean output = obj.isPowerOfFour(32);
		System.err.println(output);

	}

	public boolean isPowerOfFour(int n) {
		
		if(n<1) return false;
		
		if(n==1) {
			return true;
		}
		
		if(n%4 != 0) {
			return false;
		}
		
		return isPowerOfFour(n/4);
		
	}
}
