package arrays.java;
import java.util.*;

public class ArrayWithoutDuplicates {
	
public static boolean isDuplicateExists(List<Integer> list) {
	// THis function is to be filled in by the user
	list.sort(Comparator.naturalOrder());
	for (int i=0;i<list.size()-1; i++) {
		if (list.get(i)==list.get(i+1))
			return true;
	}
	return false;
}
public static void main(String args[]) {
	// Call this function with input from test cases or custom input from user
	List<Integer> list1= Arrays.asList(1, 2,5,3,4,2);
	//expected answer true
	System.out.println(isDuplicateExists(list1));
	// Expected answer false but null pointer exception due to bug in code
	List<Integer> list2= Arrays.asList(1, 2,5,3,4,7);
	System.out.println(isDuplicateExists(list2));
	 
}
}
