package linkedlist;

public class PrintLinkedList {

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	/**
	 * Printing the LinkedList
	 * 
	 * @param node
	 */
	public void printKthNodeFromEndLL(int k) {
		Node n1 = head, n2 = head;
		int i = 1;
		while (i < k) {
			n1 = n1.next;
			i++;
		}
		while (n1.next != null) {
			n1 = n1.next;
			n2 = n2.next;
			System.out.println(n2.data);
		}
		System.out.println(n2.data);
	}

	// Function to return the nth node from the end of a linked list.
	// Takes the head pointer to the list and n as input
	// Returns the nth node from the end if one exists else returns NULL.
	public Node nthToLast(Node head, int n) {
		// If list does not exist or if there are no elements in the list,return
		// NULL
		if (head == null || n < 1) {
			return null;
		}

		// make pointers p1 and p2 point to the start of the list.
		Node p1 = head;
		Node p2 = head;

		// The key to this algorithm is to set p1 and p2 apart by n-1 nodes
		// initially
		// so we want p2 to point to the (n-1)th node from the start of the list
		// then we move p2 till it reaches the last node of the list.
		// Once p2 reaches end of the list p1 will be pointing to the nth node
		// from the end of the list.

		// loop to move p2.
		for (int j = 0; j < n - 1; ++j) {
			// while moving p2 check if it becomes NULL, that is if it reaches
			// the end
			// of the list. That would mean the list has less than n nodes, so
			// its not
			// possible to find nth from last, so return NULL.
			if (p2 == null) {
				return null;
			}
			// move p2 forward.
			p2 = p2.next;
		}

		// at this point p2 is (n-1) nodes ahead of p1. Now keep moving both
		// forward
		// till p2 reaches the last node in the list.
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		// at this point p2 has reached the last node in the list and p1 will be
		// pointing to the nth node from the last..so return it.
		return p1;
	}

	public static void main(String[] args) {
		PrintLinkedList list = new PrintLinkedList();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(40);
		list.head.next.next.next = new Node(30);
		list.head.next.next.next.next = new Node(50);
		System.out.println(" LinkedList ");
		list.printKthNodeFromEndLL(2);

	}

}
