package io.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationExample {

	public static void main(String ar[]) {

		try (FileInputStream fis = new FileInputStream("D:/example/Emp.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			Employee emp = (Employee) ois.readObject();
			System.out.println(emp);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
