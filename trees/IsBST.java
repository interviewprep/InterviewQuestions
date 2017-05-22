/*
 * Check if a tree is a binary search tree
 */

package trees;

public class IsBST {
	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	/*
	 * The properties of a binary search tree are that the left descendants of a
	 * node are less than that node in value, and the right descendants of a
	 * node are greater than or equal to that node in value.
	 */
	public static boolean isValidBST(TreeNode root, long minVal, long maxVal) {
		if (root == null)
			return true;
		if (root.val >= maxVal || root.val <= minVal)
			return false;

		// any node further down left will be less than the value of the this
		// node
		// any node further down right will be at least as large as the this
		// node
		return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
	}

	public static void main(String args[]) {
		TreeNode a = new TreeNode(10);
		TreeNode b = new TreeNode(20, null, a);
		TreeNode root = new TreeNode(15, b, null);
		/*
		 *         15
		 *     20       null
		 *  null  10
		 */
		System.out.println(isValidBST(root));
	}

}
