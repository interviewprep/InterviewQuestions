
public class LoopLinkedList {

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	boolean hasLoop(Node first) {

		if (first == null) // list does not exist..so no loop either.
			return false;

		Node slow, fast; // create two references.

		slow = fast = first; // make both refer to the start of the list.

		while (true) {

			slow = slow.next; // 1 hop.

			if (fast.next != null)
				fast = fast.next.next; // 2 hops.
			else
				return false; // next node null => no loop.

			if (slow == null || fast == null) // if either hits null..no loop.
				return false;

			if (slow == fast) // if the two ever meet...we must have a loop.
				return true;
		}
	}

	public static void main(String[] args) {
		LoopLinkedList list = new LoopLinkedList();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(40);
		list.head.next.next.next = new Node(30);
		list.head.next.next.next.next = new Node(50);
		list.head.next.next.next.next.next = list.head.next.next;
		System.out.println(" LinkedList ");
		System.out.println(list.hasLoop(head));

	}

}
