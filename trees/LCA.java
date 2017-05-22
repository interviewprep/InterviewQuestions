
/*
 * Find the lowest common ancestor of two nodes in a binary tree
 * 
 */

package trees;

public class LCA {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		// watch for corner case where one node may be the parent of other node

		if (root == null || root == p || root == q)
			return root;

		// Check left subtree and right subtree for the common ancestor
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		// if one of the nodes is in the left subtree and one in the right
		// subtree, the
		// current node is the lowest common ancestor.
		if (left != null && right != null)
			return root;
		// if only of them is not null, the other one is the lowest common
		// ancestor that
		// has been recursively returned to us.
		return left != null ? left : right;
	}

	public static void main(String args[]) {
		TreeNode a = new TreeNode(10);
		TreeNode b = new TreeNode(20, null, a);
		TreeNode d = new TreeNode(40);
		TreeNode root = new TreeNode(15, b, d);
		/*
		 *         15
		 *     20       40
		 *  null  10
		 */
		System.out.println(lowestCommonAncestor(root, a, d));
	}

}
