package linkedlist;

public class ReArrangeLinkedList {

	// Java program to rearrange link list in place

	// Linked List Class

	static Node head; // head of list

	/* Node Class */
	static class Node {

		int data;
		Node next;

		// Constructor to create a new node
		Node(int d) {
			data = d;
			next = null;
		}
	}

	void printlist(Node node) {
		if (node == null) {
			return;
		}
		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
	}

	Node reverselist(Node node) {
		Node prev = null, curr = node, next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		node = prev;
		return node;
	}

	void rearrange(Node node) {

		// 1) Find the middle point using tortoise and hare method
		Node slow = node, fast = slow.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// 2) Split the linked list in two halves
		// node1, head of first half 1 -> 2 -> 3
		// node2, head of second half 4 -> 5
		Node nodeList = node;
		Node list2 = slow.next;
		slow.next = null;

		// 3) Reverse the second half, i.e., 5 -> 4
		list2 = reverselist(list2);

		// 4) Merge alternate nodes
		node = new Node(0); // Assign dummy Node

		// curr is the pointer to this dummy Node, which will
		// be used to form the new list
		Node curr = node;
		while (nodeList != null || list2 != null) {

			// First add the element from first list
			if (nodeList != null) {
				curr.next = nodeList;
				curr = curr.next;
				nodeList = nodeList.next;
			}

			// Then add the element from second list
			if (list2 != null) {
				curr.next = list2;
				curr = curr.next;
				list2 = list2.next;
			}
		}

		// Assign the head of the new list to head pointer
		node = node.next;
	}

	public static void main(String[] args) {

		ReArrangeLinkedList list = new ReArrangeLinkedList();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(5);

		list.printlist(head); // print original list
		list.rearrange(head); // rearrange list as per ques
		System.out.println("");
		list.printlist(head); // print modified list

	}

}
