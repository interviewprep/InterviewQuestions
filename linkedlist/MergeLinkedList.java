package linkedlist;

public class MergeLinkedList {
	public  Node head;

	static class Node {
		public int data;
		public Node next;

		Node(int data) {
			this.data = data;
		}
	}
	/**
	 * Merge two LinkedLists in Sorted order
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static Node mergeTwoLists(Node l1, Node l2) {
	    Node head = new Node(0);
	    Node mergedList=head;
	 
	    Node p1=l1;
	    Node p2=l2;
	    while(p1!=null && p2!=null){
	    	//compare the  elements from each list. If p1 is smaller add to the merged list else p2
	        if(p1.data < p2.data){
	            mergedList.next = p1;
	            p1 = p1.next;
	        }else{
	            mergedList.next = p2;
	            p2 = p2.next;
	        }
	        mergedList=mergedList.next;
	    }
	 
	    if(p1!=null){
	        mergedList.next = p1;
	    }
	 
	    if(p2!=null){
	        mergedList.next = p2;
	    }
	 
	    return head.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeLinkedList list1 = new MergeLinkedList();
		list1.head = new Node(10);
		list1.head.next = new Node(20);
		list1.head.next.next = new Node(40);
		
		MergeLinkedList list2 = new MergeLinkedList();
		list2.head = new Node(50);
		list2.head.next = new Node(60);
		list2.head.next.next = new Node(70);
		Node n = mergeTwoLists(list1.head, list2.head);
		while(n.next!=null){
			System.out.println(n.data);
			n=n.next;
		}
		
	}

}
