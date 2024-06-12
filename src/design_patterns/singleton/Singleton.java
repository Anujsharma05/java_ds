package design_patterns.singleton;

public class Singleton {

	private static Singleton singleton;

	private Singleton() {
	}

	/** Lazy Initialization, not thread safe **/
	public static Singleton getInstance() {
		if (singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}

	public static Singleton getThreadSafeInstance() {
		Singleton result = singleton;
		if (result != null) {
			return result;
		}
		synchronized (Singleton.class) {
			if (singleton == null) {
				singleton = new Singleton();
			}
		}
		return singleton;
	}
}
