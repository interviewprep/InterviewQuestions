# Column Order Traversal
# Write a traversal method for Binary Tree that prints nodes that fall on a
# line from leftmost to rightmost.
# Example: For following Binary Tree,
#
#       4
#      / \
#     2   5
#    / \   \
#   1   3   7
#
# Column order traversal = [1, 2, 4, 3, 5, 7] 
#
# Explanation: If we draw lines vertically, then we will see that 
#
#   | | 4 | |
#   | | | | |
#   | 2 | 5 |
#   | | | | |
#   1 | 3 | 7
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

def column_order(root):
    columns = {}
    preorder(root, 0, columns)
    return [columns[k] for k in sorted(columns)]
    
def preorder(node, distance, columns):
    if node:
        if distance in columns:
            columns[distance].append(node.val)
        else:
            columns[distance] = [node.val]
        
        preorder(node.left, distance - 1, columns)
        preorder(node.right, distance + 1, columns)


        
