package leetcode.easy;

public class PowerOfFour {

	public static void main(String[] args) {
		
		PowerOfFour obj = new PowerOfFour();
		boolean output = obj.isPowerOfFour(24);
		System.err.println(output);
	}

	public boolean isPowerOfFour(int num) {
		
//        int p = 1;
//        if(n==1) {
//        	return true;
//        }
//        if(n%4 != 0 || n==0) {
//        	return false;
//        }
//		while(true) {
//			p = p * 4;
//			if(p==n) {
//				return true;
//			} else if(p > Integer.MAX_VALUE || p == 0) {
//				return false;
//			}
//		}
		
		  if(num == 0) return false;
	         while(num != 1){
	             if(num % 4 != 0) return false;
	             num /= 4;
	         }
	        return true;
    }
}
