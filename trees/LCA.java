package trees;

import trees.BinaryTreePrototypeTemplate.BinaryTreeNode;

public class LCA {
    public BinaryTreeNode<Integer> lowestCommonAncestor(BinaryTreeNode<Integer> root, 
    		BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {
        if(root == null || root == p || root == q)  return root;
        BinaryTreeNode<Integer> left = lowestCommonAncestor(root.left, p, q);
        BinaryTreeNode<Integer> right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }
}
