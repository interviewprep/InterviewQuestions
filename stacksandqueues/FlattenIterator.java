package stacksandqueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FlattenIterator {
	Stack<List<NestedInteger>> stack;

	FlattenIterator(List<NestedInteger> list) {
		stack = new Stack<>();
		stack.push(list);
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public Integer next() {
		while (hasNext()) {
			List<NestedInteger> curr = stack.pop();
			NestedInteger next = null;
			if (!curr.isEmpty()) {
				next = curr.remove(0);
				if (next.nodeType != NodeType.Integer) {
					// add the current list to stack
					addListtoStack(curr);
					// add new list to stack 
					addListtoStack(next.list);
					continue;
				} else { // next is integer
					addListtoStack(curr);
					return next.num;
				}

			}

		}

		return null;
	}

	private void addListtoStack(List<NestedInteger> list) {
		if (!list.isEmpty())
			stack.push(list);
	}

	public static void main(String args[]) {
		List<NestedInteger> list1 = new ArrayList<NestedInteger>();
		list1.add(new NestedInteger(NodeType.Integer, 10, null));
		list1.add(new NestedInteger(NodeType.Integer, 20, null));
		list1.add(new NestedInteger(NodeType.List, null, new ArrayList<NestedInteger>()));
		 list1.add(new NestedInteger(NodeType.Integer, 30, null));
		FlattenIterator fi = new FlattenIterator(list1);
		while (fi.hasNext()) {
			System.out.println(fi.next());
		}
	
	}
}

class NestedInteger {
	NodeType nodeType;
	Integer num;
	List<NestedInteger> list;

	NestedInteger(NodeType n, Integer i, List<NestedInteger> l) {
		nodeType = n;
		num = i;
		list = l;
	}
}

enum NodeType {
	Integer, List
}
