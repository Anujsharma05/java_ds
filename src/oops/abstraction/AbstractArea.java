package oops.abstraction;

abstract class Shape {
	double length, height;

	{
		System.err.println("initialization block");
	}

	Shape(double l, double h) {
		length = l;
		height = h;
	}

	static void greeting() {
		System.out.println("Hi from Shape");
	}

	abstract double area();
}

class Rectangle extends Shape {

	Rectangle(double l, double h) {
		super(l, h);
	}

	@Override
	double area() {
		return length * height;
	}
}

class Triangle extends Shape {

	Triangle(double l, double h) {
		super(l, h);
	}

	@Override
	double area() {
		return 0.5 * length * height;
	}
}

public class AbstractArea {

	public static void main(String[] args) {

		Shape.greeting();
		Shape s = new Rectangle(5, 6);
		System.err.println(s.area());
		s = new Triangle(5, 6);
		System.err.println(s.area());
	}

}
