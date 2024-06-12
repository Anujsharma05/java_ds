package enums_switch;

public enum Colors {
	YELLOW("yellow"), GREEN("green"), RED("red");

	private String colorName;

	Colors(String colorName) {
		this.colorName = colorName;
	}

	public void testMethod() {
		System.out.println(Colors.this == Colors.RED);
		System.out.println(colorName);
		System.out.println(this.name());
	}

}
