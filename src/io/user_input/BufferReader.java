package io.user_input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReader {

	public static void main(String[] args) {

		/**
		 * System.in specifies keyboard input
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			String name = in.readLine();
			System.err.println(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
