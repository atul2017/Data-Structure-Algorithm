/* Invert the Binary Tree
Problem Description
Given a binary tree A, invert the binary tree and return it.
Inverting refers to making the left child the right child and vice versa.
Problem Constraints
1 <= size of tree <= 100000
Input Format
First and only argument is the head of the tree A.
Output Format
Return the head of the inverted tree.

TC = O(N)
SC = O(H)
 */


package Trees;

public class InvertedBinaryTree {
    public TreeNode invertTree(TreeNode A) {
        return invert(A);
    }
    TreeNode invert(TreeNode root){
        if(root ==null){
            return null;
        }
        TreeNode tempNode = invert(root.left);
        root.left = invert(root.right);
        root.right = tempNode;
        return root;
    }
}

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
