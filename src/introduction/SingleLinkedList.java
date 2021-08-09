package introduction;

public class SingleLinkedList {

	Node head;
	
	Node tail;
	
	int size;
	
	public Node createLinkedList(int data) {
		
		Node node = new Node(data);
		node.next = null;
		head = node;
		tail = node;
		size = 1;
		
		return head;
	}
	
	public void insertNode(int data, int location) {
		
		if(head == null) {
			createLinkedList(data);
			return;
		}
		
		Node node = new Node(data);
		
		if(location == 0) {
			node.next = head;
			head = node;
		} else if(location >= size) {
			tail.next = node;
			node.next = null;
			tail = node;
		} else {
			int pos = 0;
			Node temp = head;
			while(pos<location-1) {
				temp = temp.next;
				pos++;
			}
			
			node.next = temp.next;
			temp.next = node;
		}
		size++;
	}
	
	public void traverseList() {
		
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.err.println();
	}
	
	public int search(int data) {
		
		if(head == null) System.err.println("linked list does not exist");
		
		Node temp = head;
		int pos = 0;
		while(temp != null) {
			if(temp.data == data) {
				return pos;
			}
			temp = temp.next;
			pos++;
		}
		return -1;
	}
}
