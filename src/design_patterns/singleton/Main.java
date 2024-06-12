package design_patterns.singleton;

public class Main {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getThreadSafeInstance();
		Singleton s2 = Singleton.getThreadSafeInstance();
		System.out.println(s1.hashCode() == s2.hashCode());
	}

}
