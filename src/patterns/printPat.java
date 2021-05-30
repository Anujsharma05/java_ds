package patterns;

public class printPat {

	public static void main(String[] args) {
		printPattern(2);
		
//		int arr[] = {1, 2, 3, 4, 5};
//		int n = arr.length;
//		
//		for(int i=0; i<n; i=i+2) {
//			System.out.print(arr[i] + " ");
//		}
		
	}
	
	public static void printPattern(int n) {
		
		for(int k=n; k>0; k--) {
			for(int i=n; i>0; i--) {
				for(int j=0; j<k; j++) {
					System.out.print(i+ " ");
				}
			}
			System.out.print("$");
		}
	}

}
