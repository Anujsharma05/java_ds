package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BufferedReaderExample {

	public static void main(String[] args) {

		try (FileReader fr = new FileReader("D:/example/my_data.txt"); BufferedReader br = new BufferedReader(fr);) {

			String line;
			int count = 0;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);

				while (st.hasMoreTokens()) {
					System.out.println(st.nextToken());
					count++;
				}
			}
			System.out.println(count);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
