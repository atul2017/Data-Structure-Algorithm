/*Morris Inorder Traversal
Problem Description
Given a binary tree, return the inorder traversal of its nodes' values.
NOTE: Using recursion and stack are not allowed.
Problem Constraints
1 <= number of nodes <= 10^5
Input Format
First and only argument is root node of the binary tree, A.
Output Format
Return an integer array denoting the inorder traversal of the given binary tree.

TC = O(N)
SC = O(1)
 */

package Trees;

import java.util.ArrayList;

public class MorrisInorderTraversal {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> inOrderTraversal = new ArrayList<>();
        TreeNode curr = A;
        while(curr!=null){
            if(curr.left==null){
                inOrderTraversal.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode rightMostNode = RightMostNode(curr);
                if(rightMostNode.right==null){ //visiting right most node first time
                    rightMostNode.right = curr;
                    curr = curr.left;
                }else{ //visiting right most node second time
                    inOrderTraversal.add(curr.val);
                    rightMostNode.right = null;
                    curr = curr.right;
                }
            }
        }
        return inOrderTraversal;
    }

    //this method is to find out the rightmost node for any subtree
    TreeNode RightMostNode(TreeNode curr){
        TreeNode tempNode = curr.left;
        while(tempNode.right!=null && tempNode.right != curr){
            tempNode = tempNode.right;
        }
        return tempNode;
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