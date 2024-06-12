package oops.interfaces;

interface A {
	void study();
}

interface B {
	void study();
}

interface D extends B {
	int NUM = 33;

//	void study();
}

class C implements A, B {

	@Override
	public void study() {
		System.err.println("study");
	}
}

class F implements D {
	@Override
	public void study() {
		System.out.println(NUM);
	}
}

public class MultipleInheritance {

	public static void main(String[] args) {

		C obj = new C();
		obj.study();

		D ref = new F();
		ref.study();

	}
}
