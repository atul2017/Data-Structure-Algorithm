/*Search in BST
Problem Description
Given a Binary Search Tree A. Check whether there exists a node with value B in the BST.
Problem Constraints
1 <= Number of nodes in binary tree <= 105
0 <= B <= 10^6
Input Format
First argument is a root node of the binary tree, A.
Second argument is an integer B.
Output Format
Return 1 if such a node exist and 0 otherwise

TC=O(N)
SC=O(1)
*/
package Trees;
public class SearchInBST {
    public int solve(TreeNode A, int B) {
        while(A!=null){
            int val = A.val;
            if(B<val){
                A=A.left;
            }else if(B>val){
                A=A.right;
            }else{
                return 1;
            }
        }
        return 0;
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

