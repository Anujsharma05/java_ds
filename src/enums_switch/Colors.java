package enums_switch;

public enum Colors {
    YELLOW("yellow"),
    GREEN("green"),
    RED("red");

    Colors(String colorName) {
        this.colorName = colorName;
    }
    private String colorName;

    public void testMethod() {
        System.out.println(Colors.this);
        System.out.println(colorName);
    }

}
