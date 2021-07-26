package strings;

public class RemoveVowels {

	public static void main(String[] args) {
		
		String input = "Anuj";
		
		String output = removeVowels(input);
		System.out.print(output);
	}

	private static String removeVowels(String input) {
		
		StringBuilder s = new StringBuilder();
		s.replace(0, 0, "abc");
		
		System.out.println(s.length());
		
		if(input == null || input.length() == 0) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		char[] chars = input.toCharArray();
		
		for(char c: chars) {
			if(!isVowel(c)) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	private static boolean isVowel(char c) {
		
		switch(c) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
		case 'A':
		case 'E':
		case 'I':
		case 'O':
		case 'U': 
			return true;
		default:
			return false;
		}
	}
}
