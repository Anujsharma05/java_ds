package loops;

public class MultiplicationTable {

	public static void main(String[] args) {
		
		for(int i = 1; i <= 11; i++) {
			for(int j = 1; j<=20; j++) {
				System.out.print(j * i + " ");
			}
			System.err.println();
		}

	}

}
