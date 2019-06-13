# Mirror a Binary Tree
# Change a tree so that all the left and right pointers are swapped at every node. 
# This will result in a mirror image of a Binary Tree
#
# So the tree...
#       4
#      / \
#     2   5
#    / \
#   1   3
#
# is changed to...
#       4
#      / \
#     5   2
#        / \
#       3   1
#
# Source - http://cslibrary.stanford.edu/110/BinaryTrees.html
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

def mirror(root):
	if not root:
		return
	else:
		mirror(root.left)
		mirror(root.right)
		root.left, root.right = root.right, root.left
