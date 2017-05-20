package linkedlist;

import java.util.HashMap;

public class IntersectionLinkedList {
	public Node head;

	static class Node {
		private Node next;
		private int data;

		public Node(int data) {
			this.data = data;
		}
		/*
		 * @Override public boolean equals(Object o){ return
		 * this.data==((Node)o).data; }
		 * 
		 * public int hashCode(){ return data;
		 * 
		 * }
		 */
	}

	public static Node findInsectionNode(Node l1, Node l2) {
		HashMap<Node, Integer> nodesMap = new HashMap<Node, Integer>();
		Node t = l1;
		while (t != null) {
			nodesMap.put(t, t.data);
			t = t.next;
		}
		Node t2 = l2;
		while (t2 != null) {
			if (nodesMap.containsKey(t2)) {
				return t2;

			} else {
				t2 = t2.next;
			}
		}
		return null;
	}

	/*
	 * function to get the intersection point of two linked lists head1 and
	 * head2
	 */
	static int getNode(Node head1, Node head2) {
		int c1 = getCount(head1);
		int c2 = getCount(head2);
		int d;

		if (c1 > c2) {
			d = c1 - c2;
			return getIntesectionNode(d, head1, head2);
		} else {
			d = c2 - c1;
			return getIntesectionNode(d, head2, head1);
		}
	}

	/*
	 * function to get the intersection point of two linked lists head1 and
	 * head2 where head1 has d more nodes than head2
	 */
	static int getIntesectionNode(int d, Node node1, Node node2) {
		int i;
		Node current1 = node1;
		Node current2 = node2;
		for (i = 0; i < d; i++) {
			if (current1 == null) {
				return -1;
			}
			current1 = current1.next;
		}
		while (current1 != null && current2 != null) {
			if (current1.data == current2.data) {
				return current1.data;
			}
			current1 = current1.next;
			current2 = current2.next;
		}

		return -1;
	}

	/*
	 * Takes head pointer of the linked list and returns the count of nodes in
	 * the list
	 */
	static int getCount(Node node) {
		Node current = node;
		int count = 0;

		while (current != null) {
			count++;
			current = current.next;
		}

		return count;
	}

	public static void main(String[] args) {
		IntersectionLinkedList iLL = new IntersectionLinkedList();
		iLL.head = new Node(10);
		iLL.head.next = new Node(20);
		iLL.head.next.next = new Node(40);

		IntersectionLinkedList iLL2 = new IntersectionLinkedList();
		iLL2.head = new Node(50);
		iLL2.head.next = new Node(60);
		iLL2.head.next.next = new Node(70);

		IntersectionLinkedList iLL3 = new IntersectionLinkedList();
		iLL3.head = new Node(1000);
		iLL3.head.next = new Node(80);
		iLL3.head.next.next = new Node(90);

		iLL2.head.next.next.next = iLL3.head;
		iLL.head.next.next.next = iLL3.head;

		Node intersectNode = findInsectionNode(iLL.head, iLL2.head);
		System.out.println(intersectNode.data);

		System.out.println(getNode(iLL.head, iLL2.head));
	}
}
