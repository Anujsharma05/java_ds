package conditional;

public class EnhancedSwitch {

	public static void main(String[] args) {
		
		String fruit = "mango";
		int day = 6;

		switch(fruit) {
		case "mango" -> {
			System.err.println("king of fruits");

			switch(day) {
			case 1,2,3,4,5 -> System.out.println("Weekday");
			case 6,7 -> System.out.println("Weekend");
			}
		}
		case "apple" -> System.out.println("red fruit");
		case "orange" -> System.out.println("citrous fruit");
		default -> System.out.print("no such fruit");
		}
	}

}
