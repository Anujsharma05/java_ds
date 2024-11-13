package string_buffer_builder;

import java.util.Random;

public class StrBuffer {

	public static void main(String[] args) {
		
//		basics();

		generateRandomString();
	}

	public static void basics() {
		StringBuffer sb1 = new StringBuffer();
		System.err.println(sb1.capacity());

		StringBuffer sb2 = new StringBuffer(5);
		System.err.println(sb2.capacity());

		StringBuffer sb3 = new StringBuffer("java");
		System.err.println(sb3.capacity());
		sb3.append("helloworldhallela");
		//new capacity = (old capacity*2) + 2
		System.err.println(sb3.capacity());

		//Useful SB methods

		StringBuffer sb4 = new StringBuffer("Buffer");

		//delete from start to end-1
		System.err.println(sb4.delete(5,6));

		//insert at index with given string
		System.err.println(sb4.insert(5, "r"));
		System.err.println(sb4.insert(0, "String "));

		//replace start to end-1 with given string
		System.err.println(sb4.replace(0, 3, "k"));

		System.err.println(sb4.reverse());

		//using different way of writing for loop with comma separated mulitple parts
		reverseString(sb4.toString());
	}

	public static void reverseString(String str) {
		
		char[] chrArray = str.toCharArray();
		
		for(int i=str.length()-1,j=0; i>=0; i--,j++) {
			chrArray[j] = str.charAt(i);
		}
		System.err.println(new String(chrArray));
	}

	public static void generateRandomString() {
		Random random = new Random();

		float f = random.nextFloat();
		System.out.println("float:" + f);
		System.out.println((int)(f * 26));
	}
}
