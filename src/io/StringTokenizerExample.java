package io;

import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {

		String s = "You ,are, the ,creator, of, your, destiny";

		StringTokenizer st = new StringTokenizer(s);
		StringTokenizer st1 = new StringTokenizer(s, ",", false);

		while (st1.hasMoreTokens()) {
			System.out.println(st1.nextToken().trim());
		}
	}

}
