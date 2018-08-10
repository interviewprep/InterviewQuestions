package trees;

import java.util.Stack;

public class PostOrderWithoutRecursion {
	public static void postOrderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root !=null) {
			stack.push(root);
			root = root.left;
		}
		//start traversing the tree
		TreeNode prevNode = null;
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.right == null || node.right == prevNode) {
				System.out.println(node);
				prevNode = node;
				continue;
			}
			stack.push(node);
			node = node.right;
			while (node != null) {
			    stack.push(node);
			    node = node.left;
			}		
		}
	}
	public static void main (String args[]) {
		TreeNode a = new TreeNode(15);
		TreeNode b = new TreeNode(10, null, a);
		TreeNode d = new TreeNode(40);
		TreeNode root = new TreeNode(20, b, d);
		/*
		 *         20
		 *     10       40
		 *  null  15
		 *     
		 */
		postOrderTraversal(root);
		
	}
}
