package trees;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import trees.BinaryTreePrototypeTemplate.BinaryTreeNode;

public class ReconstructBinaryTreePreInorders {
	// @include
	public static BinaryTreeNode<Integer> binaryTreeFromPreorderInorder(
			List<Integer> preorder, List<Integer> inorder) {
		Map<Integer, Integer> nodeToInorderIdx = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.size(); ++i) {
			nodeToInorderIdx.put(inorder.get(i), i);
		}
		return binaryTreeFromPreorderInorderHelper(
				preorder, 0, preorder.size(), 0, inorder.size(), nodeToInorderIdx);
	}

	// Builds the subtree with preorder.subList(preorderStart, preorderEnd) and
	// inorder.subList(inorderStart, inorderEnd).
	private static BinaryTreeNode<Integer> binaryTreeFromPreorderInorderHelper(
			List<Integer> preorder, int preorderStart, int preorderEnd,
			int inorderStart, int inorderEnd,
			Map<Integer, Integer> nodeToInorderIdx) {
		if (preorderEnd <= preorderStart || inorderEnd <= inorderStart) {
			return null;
		}
		int rootInorderIdx = nodeToInorderIdx.get(preorder.get(preorderStart));
		int leftSubtreeSize = rootInorderIdx - inorderStart;

		return new BinaryTreeNode<>(
				preorder.get(preorderStart),
				// Recursively builds the left subtree.
				binaryTreeFromPreorderInorderHelper(
						preorder, preorderStart + 1, preorderStart + 1 + leftSubtreeSize,
						inorderStart, rootInorderIdx, nodeToInorderIdx),
				// Recursively builds the right subtree.
				binaryTreeFromPreorderInorderHelper(
						preorder, preorderStart + 1 + leftSubtreeSize, preorderEnd,
						rootInorderIdx + 1, inorderEnd, nodeToInorderIdx));
	}
}
