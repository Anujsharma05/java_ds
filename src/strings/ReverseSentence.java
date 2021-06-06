package strings;

public class ReverseSentence {

	public static void main(String[] args) {
		
		String sen = "I love     java, the coffe";
		
		String[] words = sen.split(" ");
		int n = words.length;
		for(int i=0; i< n/2; i++) {
			String temp = words[i];
			words[i] = words[n-1-i];
			words[n-1-i] = temp;
		}

		for(String w: words) {
			System.err.print(w + " ");
		}
		
	}

}
