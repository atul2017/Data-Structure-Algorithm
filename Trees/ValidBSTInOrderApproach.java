/*Valid Binary Search Tree
Problem Description
You are given a binary tree represented by root A.
Assume a BST is defined as follows:
1) The left subtree of a node contains only nodes with keys less than the node's key.
2) The right subtree of a node contains only nodes with keys greater than the node's key.
3) Both the left and right subtrees must also be binary search trees.

Problem Constraints
1 <= Number of nodes in binary tree <= 10^5
0 <= node values <= 232-1
Input Format
First and only argument is head of the binary tree A.
Output Format
Return 0 if false and 1 if true.

TC = O(N) //traversing each node in the tree once
SC = O(N+H) //N for ArrayList and H for recursive stack call

 */


package Trees;

import java.util.ArrayList;

public class ValidBSTInOrderApproach {
    ArrayList<Integer> inOrderList = new ArrayList<>();
    public int isValidBST(TreeNode A) {
        inOrderTraversal(A);
        for(int d=0;d<inOrderList.size()-1;d++){
            if(inOrderList.get(d)>=inOrderList.get(d+1)){
                  return 0;
            }
        }
        return 1;
    }
    void inOrderTraversal(TreeNode root){
        if(root==null) {
            return;
        }
        //Inorder traversal
        inOrderTraversal(root.left);
        inOrderList.add(root.val);
        inOrderTraversal(root.right);
    }
}
