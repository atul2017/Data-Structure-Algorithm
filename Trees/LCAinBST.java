/*  LCA in BST
Problem Description
Given a Binary Search Tree A. Also given are two nodes B and C. Find the lowest common ancestor of the two nodes.
Note 1 :- It is guaranteed that the nodes B and C exist.
Note 2 :- The LCA of B and C in A is the shared ancestor of B and C that is located farthest from the root.

Problem Constraints
1 <= Number of nodes in binary tree <= 10^5
1 <= B , C <= 10^5

Input Format
First argument is a root node of the binary tree, A.
Second argument is an integer B.
Third argument is an integer C.

Output Format
Return the LCA of the two nodes

TC=O(N)
SC=O(1)
 */

package Trees;

public class LCAinBST {
    public int solve(TreeNode A, int B, int C) {
        TreeNode curr = A;
        while(curr!=null){
            //find the first node which has value between B and C
            if(curr.val>B && curr.val>C){
                curr = curr.left;
            }else if(curr.val<B && curr.val<C){
                curr = curr.right;
            }else{
                return curr.val;
            }
        }
        return curr.val;
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
