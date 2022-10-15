package lambda_expression;

//Thread definition
class MyRunnable implements Runnable {
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("Child thread: " + i);
		}
	}
}

public class ThreadDemo {
	public static void main(String args[]) {
		
//		Runnable r = new MyRunnable();
		
		Runnable r = () -> {
			for(int i=0; i<10; i++) {
				System.out.println("Child thread: " + i);
			}
		};
		
		Thread t1 = new Thread(r);
		t1.start();
		
		for(int i=0; i<10; i++) {
			System.out.println("Main thread: " + i);
		}
	}
}
