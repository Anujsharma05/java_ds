package oops.interfaces;

interface A {
	void study();
}

interface B {
	void study();
}

class C implements A, B{
	
	public void study() {
		System.err.println("study");
	}
}

public class MultipleInheritance {

	public static void main(String[] args) {
		
		C obj = new C();
		obj.study();

	}
}
