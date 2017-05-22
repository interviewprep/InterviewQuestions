/*
 * Calculate depth of tree.
 */

package trees;


/*
 * depth of tree is 1 + deepest sub tree.
 */
public class Depth {
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	
	public static void main (String args[ ])  {
		TreeNode left = new TreeNode(10);
		TreeNode right = new TreeNode(20);
		TreeNode root = new TreeNode(10, left, right);
		System.out.println(maxDepth(root)); 
	}
}
