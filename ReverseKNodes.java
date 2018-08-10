

public class ReverseKNodes {
	public static Node reverseK(Node start, int k) {
		Node head = null;
		Node tail = null;
		Node cur = start;
		Node next = null;

		while (cur != null) {
			next = getNextKNode(cur, k);
			Node reversedHead = reverseList(cur);
			if (head == null) {
				head = reversedHead;
				tail = reversedHead;
				while (tail.next != null) {
					tail = tail.next;
				}
			} else {
				// append the reversedNode to current list
				tail.next = reversedHead;
				while (tail.next != null)
					tail = tail.next;
			}

			cur = next;
		}

		return head;
	}

	private static Node getNextKNode(Node cur, int k) {
		Node next = cur;
		while (k > 1 && next != null) {
			next = next.next;
			k--;
		}
		if (next != null) {
			Node temp = next.next;
			next.next = null;
			next = temp;
		}

		return next;
	}

	private static Node reverseList(Node head) {
		Node prev = null;
		Node current = head;
		Node next = null;
		while (current != null) {
			// swap the Current Node Reference with Next Node Reference 1->2
			// becomes 2-> 1
			next = current.next;// store Next reference of current Node
			current.next = prev; // reassign the Current node's Next reference
									// with Previous Node
			prev = current; // update prev reference with current node
			current = next; // update current node reference with Next node
							// reference as mentioned in step 28
		}
		head = prev;// return the last node which is the first node after
					// reversing the list
		return head;
	}
	
    // prints content of double linked list
    private static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    
    public static void main(String args[]) {
        Node head = new Node(85);
        head.next = new Node(15);
        head.next.next = new Node(4);
        head.next.next.next = new Node(20);
        Node newHead = reverseK(head, 6);
        printList(newHead);
         
    }
}

// Linked List Node class
class Node {

	int data; // Node data
	Node next;// Next and random reference

	// Node constructor
	Node(int d) {
		data = d;
		next = null;
	}
}
