package introduction;

public class Main {

	public static void main(String[] args) {
		
		SingleLinkedList sl = new SingleLinkedList();
		sl.createLinkedList(2);
		
		sl.insertNode(1, 0);
		sl.insertNode(3, 2);
		sl.insertNode(5, 3);
		sl.insertNode(7, 4);
		sl.insertNode(9, 5);
		
		sl.traverseList();
		int pos = sl.search(7);
		System.err.println(pos);
	}

	
}
