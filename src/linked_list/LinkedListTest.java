package linked_list;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {
	public static void main(String args[]) {

		List<Integer> list = new LinkedList<>();

		list.add(4);
		list.add(2);
		list.add(5);
		list.add(6);
		list.add(9);
		System.out.println(list);
		ListIterator<Integer> itr = list.listIterator();

		while (itr.hasNext()) {
			if (itr.next() == 5) {
				itr.remove();
			}
		}
		System.out.println(list);
	}
}
