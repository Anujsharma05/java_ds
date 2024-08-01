package java_eight.supplier;

import java.util.Date;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * Supplier<R>
 * R get()
 * 
 * no static or default methods
 */
public class ExampleOne {
	public static void main(String args[]) {

//		getRandomName();
//		get6DigitOtp();
		getRandomPassword();
	}

	static void getSystemDate() {
		Supplier<Date> s = Date::new;
		System.out.println(s.get());
	}

	static void get6DigitOtp() {
		Supplier<String> s = () -> {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < 6; i++) {
				sb.append((int) (Math.random() * 10));
			}

			return sb.toString();
		};

		System.out.println(s.get());
		System.out.println(s.get());
	}

	static void getRandomName() {

		Supplier<String> s = () -> {
			String[] arr = { "abc", "bcd", "cde", "def", "efg", "fgh" };
			int index = (int) (Math.random() * 6); // math random value => 0 <= val < 1
			return arr[index];
		};

		System.out.println(s.get());
	}

	/*
	 * length 8 2,4,6,8 places are number 1,3,5,7 places are uppercase letter or #
	 * or @ or !
	 */
	static void getRandomPassword() {

		Supplier<String> s = () -> {

			StringBuilder sb = new StringBuilder();

			String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#@!";
			IntSupplier i = () -> (int) (Math.random() * 10);
			Supplier<Character> c = () -> symbols.charAt((int) (Math.random() * symbols.length()));

			for (int idx = 1; idx <= 8; idx++) {
				if (idx % 2 == 0) {
					sb.append(i.getAsInt());
				} else {
					sb.append(c.get());
				}
			}

			return sb.toString();
		};

		for (int x = 0; x < 1900; x++) {
			System.out.println(s.get());
		}
	}

}
