package interfaces;

import java.util.concurrent.Callable;

class Product implements Callable<Integer> {
	int num1;
	int num2;

	@Override
	public Integer call() {
		return num1 * num2;
	}
}

public class CallableExample {

}
