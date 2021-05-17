package arrays.multidimension;

public class MatrixMultiplication {

	public static void main(String[] args) {
		
//		2x3
		int a[][] = {
				{12 , 8 , 4},
				{3 , 17 , 14},
				{9, 8, 10}
		};
		
//		3x2
		int b[][] = {
				{5 , 19, 3},
				{6 , 15, 9},
				{7, 8, 16}
		};
		
		int c[][] = new int[3][3];
		
		for(int k=0; k<a.length;k++) {
			for(int i=0 ; i<a.length; i++) {
				int sum = 0;
				for(int j=0 ; j<a[i].length; j++) {
					 sum = sum + a[k][j]*b[j][i];
				}
				c[k][i] = sum;
				
			}
		}
		
		for(int i = 0 ; i< 3; i++) {
			for(int j = 0 ; j< 3; j++) {
				System.err.print(c[i][j] + " ");
			}
			System.err.println();
		}
		
	}

}
