package strings;

public class Anagram {

	public static void main(String[] args) {
		
		String a = "aab";
		String b = "aba";
		
		boolean isAnagram = false;
		boolean[] visited = new boolean[b.length()];
		
		
		for(int i=0; i<a.length(); i++) {
				isAnagram = false;
			for(int j=0; j<b.length(); j++) {
				if(a.charAt(i) == b.charAt(j) && !visited[j]) {
					isAnagram = true;
					visited[j] = true;
					break;
				}
			}
			
			if(!isAnagram) {
				break;
			}
		}
		
		System.err.println(isAnagram);
	}

}
