package introduction;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		
		Dog a = new Dog();
		a.legs = 3;
		
		Dog b = new Dog();
		b.legs = 4;
		
		swap(a, b);
		
		System.err.println(a.legs + " " + b.legs);
		
		int x = 13;
		print(x);
	}
	
	static void swap(Dog x, Dog y) {
		int temp = x.legs;
		x.legs = y.legs;
		y.legs = temp;
	}
	
	static void print(float a) {
		System.err.println(a);
	}
}


class Dog {
	int legs;
}