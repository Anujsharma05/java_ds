package java_eight.method_constructor_reference;

interface Interf3 {
	public Sample get();
}

class Sample {
	Sample() {
		System.out.println("constructor ref for object creation");
	}
}
public class ConstructorRefExample {

	public static void main(String[] args) {
		
		//With Lambda
		Interf3 i1 = () -> new Sample();
		Sample s1 = i1.get();
		
		//With Constructor Reference
		Interf3 i2 = Sample::new;
		Sample s2 = i2.get();

	}

}
