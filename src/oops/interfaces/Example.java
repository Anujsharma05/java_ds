package oops.interfaces;

interface Course {
	
	int num = 4;

	default void fun() {
		System.out.println("default fun course");
	}
}

interface RBRCourse extends Course {
	void publish();
}

abstract class JavaCourse implements RBRCourse {
	
	public void study() {
		System.err.println("method of abstract class");
	}

	protected abstract void hello();

	@Override
	public void publish() {
		
	}
}

class JavaSubCourse extends JavaCourse {

//	@Override
//	public void fun() {
//		System.out.println("fun overridden");
//	}

	@Override
	protected void hello() {

	}
}

public class Example {

	public static void main(String[] args) {
		
		JavaCourse obj = new JavaSubCourse();
		obj.study();
		obj.fun();
		System.out.println(Course.num);

	}

}
