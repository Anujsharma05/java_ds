package introduction;

public class Practice {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7};
		int n = arr.length;
		
		for(int i=0; i<n; i++) {
			int minIndex = i;
			boolean sorted = true;
			for(int j=i+1; j<n; j++) {
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
					sorted=false;
				}
			}
			
			if(!sorted) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
		
		for(int i: arr) {
			System.err.print(i + " ");
		}
	}

}
