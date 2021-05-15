package conditional;

public class SwitchCase {
	public static void main(String args[]) {
		
		int dayOfWeek = 3;

		switch(dayOfWeek) {
		case 1:
		case 2:
			System.err.println("I am on leave");
			break;
		case 3:
			System.err.println("Going to Office");
			break;
		case 4:
			System.err.println("Football");
			break;
		default:
		}
	}
}
