package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {

	public static void main(String[] args) {

		try (FileInputStream fis = new FileInputStream("D:/example/b.jpg");
				FileOutputStream fos = new FileOutputStream("D:/example/b_new.jpg");) {
			int data;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
