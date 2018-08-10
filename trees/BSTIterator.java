package trees;

import java.util.Stack;

public class BSTIterator {
	Stack<TreeNode> _stack;
	BSTIterator(TreeNode root) {
		_stack = new Stack<TreeNode>();
		while (root != null) {
			_stack.push(root);
			root = root.left;
		}		
	}
	public boolean hasNext() {
		return !_stack.isEmpty();
	}
	public TreeNode Next() {
		TreeNode tn = _stack.pop();
		TreeNode next = tn.right;
		while (next != null) {
			_stack.push(next);
			next = next.left;
		}
		return tn;
	}
	
	public static void main(String args[]) {
		TreeNode a = new TreeNode(15);
		TreeNode b = new TreeNode(10, null, a);
		TreeNode d = new TreeNode(40);
		TreeNode root = new TreeNode(20, b, d);
		/*
		 *         20
		 *     10       40
		 *  null  15
		 *            16
		 */
		BSTIterator bst = new BSTIterator(root);
		while (bst.hasNext()) {
			System.out.println(bst.Next());
		}
	}
	

}
