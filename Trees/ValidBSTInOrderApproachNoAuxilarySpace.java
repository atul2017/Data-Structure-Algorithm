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
SC = O(H) //H for recursive stack call

 */

package Trees;

public class ValidBSTInOrderApproachNoAuxilarySpace {
    TreeNode prev = null;

    public int isValidBST(TreeNode A) {
        boolean result = inOrderTraversal(A);
        if(result==true){
            return 1;
        }
        return 0;
    }


    boolean inOrderTraversal(TreeNode root){
        if(root!=null){

            if(!inOrderTraversal(root.left)){
                return false;
            }
            if(prev!=null && root.val <= prev.val){
                return false;
            }
            prev = root;

            return inOrderTraversal(root.right);
        }
        return true;
    }
}
