package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriterExample {

	public static void main(String[] args) {

		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("D:/example/my_data.txt");
			fw = new FileWriter("D:/example/my_data_new.txt");
			
			int ch;
			StringBuilder sb = new StringBuilder();
			while((ch = fr.read()) != -1) {
				sb.append((char)ch);
				fw.write("one ring to rule them all");
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
