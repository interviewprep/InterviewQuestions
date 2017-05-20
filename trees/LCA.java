
/*
 * Find the lowest common ancestor of two nodes in a binary tree
 * 
 */

package trees;

import trees.BinaryTreePrototypeTemplate.BinaryTreeNode;

public class LCA {
	public BinaryTreeNode<Integer> lowestCommonAncestor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> p,
			BinaryTreeNode<Integer> q) {

		// watch for corner case where one node may be the parent of other node

		if (root == null || root == p || root == q)
			return root;

		// Check left subtree and right subtree for the common ancestor
		BinaryTreeNode<Integer> left = lowestCommonAncestor(root.left, p, q);
		BinaryTreeNode<Integer> right = lowestCommonAncestor(root.right, p, q);

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
}
