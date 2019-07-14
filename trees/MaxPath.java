package trees;

/*
 * Calculate the largest path (sum of its nodes) between any two nodes in a binary tree
 */

public class MaxPath{ 
     public static int max = 0;
    
     public static int maxPathSum(TreeNode root) {
        if (root == null)
        return 0;
    	int leftMax = maxPathSumHelper(root.left);
    	int rightMax = maxPathSumHelper(root.right);

        // the largest path at this node could be just this node, or any combination of this node 
        // and the largest path through its  left and right subtrees
    	int largestPathAtNode = 
    	max4Ints(root.val, root.val + leftMax, root.val + rightMax,
    	root.val + leftMax + rightMax);
    	if (largestPathAtNode > max)
            max = largestPathAtNode;
        // Any path from a parent node either ends at root, or goes through either the left node or right node 
       // but not both. 
    	return Math.max( Math.max(leftMax, rightMax) + root.val, root.val);
      }

     public static int max4Ints(int a, int b, int c, int d) {
        int max = a;
        if (b > max)
            max =b;
        if (c> max)
            max = c;
        if (d > max)
            max = d;
        return max;
      }

      public static void main (String args[ ])  {
          TreeNode left = new TreeNode(10);
          TreeNode right = new TreeNode(20);
          TreeNode root = new TreeNode(10, left, right);
          maxPathSum(root);
          System.out.println("Max path between any two nodes in this tree is " + max);
        }
}
