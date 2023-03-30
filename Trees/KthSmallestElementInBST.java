/*Kth Smallest Element In BST
Problem Description
Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.
Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9
Input Format
First and only argument is head of the binary tree A.
Output Format
Return an integer, representing the Bth element.

TC = O(N)
SC = O(H)

 */

package Trees;

public class KthSmallestElementInBST {
    int count = 0;
    int smallestValue = 0;
    public int kthsmallest(TreeNode A, int B) {

        if(A.left!=null || A.right!=null){
            inOrderTraversal(A,B);
        }else{
            return A.val;
        }
        return smallestValue;
    }

    void inOrderTraversal(TreeNode root, int B){
        if(root==null){
            return;
        }
        inOrderTraversal(root.left,B);
        count++;
        if(count==B){
            smallestValue = root.val;
            return;
        }
        inOrderTraversal(root.right,B);
    }
}
