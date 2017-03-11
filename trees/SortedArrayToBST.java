package trees;

import trees.BinaryTreePrototypeTemplate.BinaryTreeNode;

public class SortedArrayToBST {
	public BinaryTreeNode<Integer> sortedArrayToBST(int[] num) {
		if (num.length == 0) {
			return null;
		}
		BinaryTreeNode<Integer> head = helper(num, 0, num.length - 1);
		return head;
	}

	public BinaryTreeNode<Integer> helper(int[] num, int low, int high) {
		if (low > high) { // Done
			return null;
		}
		int mid = (low + high) / 2;
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(num[mid]);
		node.left = helper(num, low, mid - 1);
		node.right = helper(num, mid + 1, high);
		return node;
	}
}
