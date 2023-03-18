/* Binary Tree From Inorder And Postorder
Problem Description
Given the inorder and postorder traversal of a tree, construct the binary tree.
NOTE: You may assume that duplicates do not exist in the tree.
Problem Constraints
1 <= number of nodes <= 10^5
Input Format
First argument is an integer array A denoting the inorder traversal of the tree.

Second argument is an integer array B denoting the postorder traversal of the tree.

Output Format
Return the root node of the binary tree.

TC = O(N)
SC = O(N)

 */

package Trees;

import java.util.ArrayList;

public class BinaryTreeFromInorderAndPostorder {

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        TreeNode resultTree = buildTree(A,B, 0,A.size()-1, 0, B.size()-1);
        return resultTree;
    }

    TreeNode buildTree(ArrayList<Integer> A,ArrayList<Integer> B, int start_in,int end_in, int start_p, int end_p){

        //base case
        if(start_in>end_in){
            return null;
        }

        //Find the root node from the post order list
        TreeNode rootNode = new TreeNode(B.get(end_p));

        //if the start and end index are same return the rootnode - no more node to traverse
        if(start_in==end_in){
            return rootNode;
        }

        //assume the root node is available at the start of inorder list
        int rootIndexInOrder = start_in;
        //this loop is to check the index of root in the preorder
        for(int d =0;d<=end_in;d++){
            if(A.get(d).equals(B.get(end_p))){
                rootIndexInOrder = d;
                break;
            }
        }

        //count the nodes in left and right subtrees
        int countLeft = rootIndexInOrder-start_in;
        int countRight = end_in - rootIndexInOrder;

        //call recursively
        rootNode.left = buildTree(A,B,start_in,rootIndexInOrder-1,start_p, start_p+countLeft-1);
        rootNode.right = buildTree(A,B, rootIndexInOrder+1, end_in, start_p+countLeft, end_p-1);
        return rootNode;
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

