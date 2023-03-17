/*Problem Description
Given a binary tree, return the inorder traversal of its nodes' values.
NOTE: Using recursion is not allowed.

Problem Constraints
1 <= number of nodes <= 10^5
Input Format
First and only argument is root node of the binary tree, A.
Output Format
Return an integer array denoting the inorder traversal of the given binary tree.

TC = O(N)
SC = O(H) //Height of the tree

 */

package Trees;

import java.util.ArrayList;

public class InorderRecursiveTraversal {
    ArrayList<Integer> resultList = new ArrayList<>();

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        if(A==null){
            return resultList;
        }
        inorderTraversal(A.left);
        resultList.add(A.val);
        inorderTraversal(A.right);
        return resultList;
    }
}
/*Definition for binary tree*/
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
 }


