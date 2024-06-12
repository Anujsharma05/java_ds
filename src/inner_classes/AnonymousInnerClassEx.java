package inner_classes;

class H {
	void hi() {
		System.out.println("parent");
	}
}

public class AnonymousInnerClassEx {

	public static void main(String[] args) {

		H h = new H() {
			@Override
			public void hi() {
				System.out.println("child");
			}
		};

		h.hi();
		Runnable r = new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 4; i++) {
					System.out.println("child thread");
				}
			}
		};

		new Thread(r).start();

		for (int i = 0; i < 3; i++) {
			System.out.println("main thread");
		}
	}
}
