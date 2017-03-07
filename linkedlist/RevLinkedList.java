// Linked List Node class
public class RevLinkedList {
	
	 
	 
	    static Node head; // Linked list head reference
	 
	    static class Node {
	 
	        int data; // Node data
	        Node next;// Next and random reference
	 
		// Node constructor
	        Node(int d) {
	            data = d;
	            next = null;
	        }
	    }
	 
	    /* Function to reverse the linked list */
	    Node reverse(Node node) {
	        Node prev = null;
	        Node current = node;
	        Node next = null;
	        while (current != null) {
	        	/**swap the Current Node Reference with Next Node Reference 
	        	 * 1->2 becomes 2-> 1
	        	 */
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }
	        node = prev;
	        return node;
	    }
	 
	    // prints content of double linked list
	    void printList(Node node) {
	        while (node != null) {
	            System.out.print(node.data + " ");
	            node = node.next;
	        }
	    }
	 
	 
	   public static void main(String[] args) {
	        RevLinkedList list = new RevLinkedList();
	        list.head = new Node(85);
	        list.head.next = new Node(15);
	        list.head.next.next = new Node(4);
	        list.head.next.next.next = new Node(20);
	         
	        System.out.println("Given Linked list");
	        list.printList(head);
	        head = list.reverse(head);
	        System.out.println("");
	        System.out.println("Reversed linked list ");
	        list.printList(head);
	    }
}
