package oops.interfaces;

interface Course {
	
	
}

interface RBRCourse extends Course {
	void publish();
}

class JavaCourse implements RBRCourse {
	
	public void study() {
		System.err.println();
	}
	
	public void publish() {
		
	}
}

public class Example {

	public static void main(String[] args) {
		
		JavaCourse obj = new JavaCourse();
		obj.study();

	}

}
