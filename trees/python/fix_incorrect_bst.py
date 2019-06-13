# Fix an incorrect Binary Search Tree
#
# There is BST with all good nodes except two of the nodes have been swapped.
# Find the incorrect values and swap them so that BST is fixed again.
# 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# Example:
#
#       4                    4
#      / \                  / \
#     2   3       =>       2   5
#    / \   \              / \   \
#   1   5   7            1   3   7
#

first = None
second = None
previous = TreeNode(float('-inf'))

def recoverTree(root):
    inorder(root)
    first.val, second.val = second.val, first.val
    
def inorder(node):
    if node:
        inorder(node.left)
        
        # If first element has not been found yet then first will be None and
        # previous will be greater than root
        if first == None and previous.val > node.val:
            first = previous
        
        # If first element has been found then it will not be None and current
        # element will be greater than root
        if first != None and previous.val > node.val:
            second = node
        
        previous = node
        inorder(node.right)
    
