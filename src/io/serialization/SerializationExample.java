package io.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try (FileOutputStream fos = new FileOutputStream("D:/example/Emp.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			Employee emp = new Employee(1, "Tanjiro", 1200.0, 33);

			oos.writeObject(emp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
