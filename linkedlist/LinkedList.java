package linkedlist;

public class LinkedList {

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	/**
	 * Recursive function to Reverse the linkedlist
	 * 
	 * @param n
	 * @return
	 */
	public Node reverseLinkedList(Node n) {
		if (n == null)
			return null;

		if (n.next == null)
			return n;
		// Next node for setting the reverse linked list
		Node nextNode = n.next;
		n.next = null;
		// Reverse the linkedlist from Second Node
		Node reverseNode = reverseLinkedList(nextNode);
		// Set the Next nodes of reversed linked list
		nextNode.next = n;
		return reverseNode;

	}

	/**
	 * Printing the LinkedList
	 * 
	 * @param node
	 */
	public void printLinkedList(Node node) {
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(10);
		list.head.next = new Node(20);
		list.head.next.next = new Node(40);
		System.out.println(" LinkedList ");
		list.printLinkedList(head);
		head = list.reverseLinkedList(head);
		System.out.println(" Printint ReversedLinkedList ");
		list.printLinkedList(head);

	}

}
