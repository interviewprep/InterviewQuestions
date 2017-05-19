package trees;

import trees.BinaryTreePrototypeTemplate.BinaryTreeNode;

/*
 * Represent a sorted array as a balanced binary search tree
 */

public class SortedArrayToBST {
	public BinaryTreeNode<Integer> sortedArrayToBST(int[] num) {
		if (num.length == 0) {
			return null;
		}
		BinaryTreeNode<Integer> head = helper(num, 0, num.length - 1);
		return head;
	}

/*
 * Intuition: to make the binary search tree balanced, the middle element must be its root.
 * Thereby making half of the elements in the left subtree and half in the right subtree
 */
	public BinaryTreeNode<Integer> helper(int[] num, int low, int high) {
		if (low > high) { // if you step outside the array bounds
			return null;
		}
		int mid = (low + high) / 2;
		// make the middle of the array as the root element
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(num[mid]);

                // construct the left and right subtrees and assign them to left and right pointers
		node.left = helper(num, low, mid - 1);
		node.right = helper(num, mid + 1, high);
		return node;
	}
}
