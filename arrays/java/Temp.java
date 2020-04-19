package arrays.java;
import java.util.*;

public class Temp {
public static void main(String args[]) {
	ArrayList<Integer> mylist = new ArrayList<Integer>();
	mylist.add(1);
	mylist.add(2);
	mylist.add(3);
	mylist.add(4);
	mylist.add(5);
	System.out.println(mylist);
	for (int i =0; i< mylist.size(); i++) {
		System.out.println(i + " at index is" + mylist.get(i));
		if (mylist.get(i)%2 == 0) {
			mylist.remove(i);
			i--;
		}
	}
	System.out.println(mylist);
}
	
}
