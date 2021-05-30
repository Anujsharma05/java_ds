package arrays;

public class PalinArray {

	public static void main(String[] args) {
		
		int arr[] = {111, 222 ,333, 444, 555};
		int n = arr.length;
		int output = 1;
		for(int i=0; i<n; i++) {
			output = checkPalin(arr[i]);
			if(output == 0) {
				break;
			}
		}
		
		System.out.println(output);
	}

	private static int checkPalin(int val) {
		int q = val;
		int r;
		int sum = 0;
		while(q>0) {
			r = q%10;
			q = q/10;
			
			sum = sum*10 + r;
		}
		if(sum == val) {
			return 1;
		}
		return 0;
	}

}

class GfG
{
	public static int palinArray(int[] a, int n)
           {
		int output = 1;
		for(int i=0; i<n; i++) {
			output = checkPalin(a[i]);
			if(output == 0) {
				break;
			}
		}
		
		return output;
           }
	
	private static int checkPalin(int val) {
		int q = val;
		int r;
		int sum = 0;
		while(q>0) {
			r = q%10;
			q = q/10;
			
			sum = sum*10 + r;
		}
		if(sum == val) {
			return 1;
		}
		return 0;
	}

}
