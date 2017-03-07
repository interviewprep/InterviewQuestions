
public class RevLinkedList {
	
	 
	 
	    static Node head; // Linked list head reference
	   
	   // Linked List Node class
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
	        	//swap the Current Node Reference with Next Node Reference 1->2 becomes 2-> 1
	            next = current.next;//store Next reference of current Node
	            current.next = prev; //reassign the Current node's Next reference with Previous Node
	            prev = current; // update prev reference with current node 
	            current = next; // update current node reference with Next node reference as mentioned in step 28
	        }
	        node = prev;//return the last node  which is the first node after reversing the list
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
