/* Sorted Array To Balanced BST
Problem Description
Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Problem Constraints
1 <= length of array <= 100000
Input Format
First argument is an integer array A.
Output Format
Return a root node of the Binary Search Tree.

TC=O(N)
SC=O(logN)
 */
package Trees;

import java.util.List;

public class SortedArrayToBalancedBST {
    public TreeNode sortedArrayToBST(final List<Integer> A) {
        TreeNode root = buildTree(A,0,A.size()-1);
        return root;
    }

    TreeNode buildTree(List A, int start, int end){
        //base case
        if(start>end){
            return null;
        }

        //find the midpoint
        int mid = (start+end)/2;

        //Node to be inserted recursively from bottom to top
        TreeNode x = new TreeNode((int)A.get(mid));

        x.left = buildTree(A,start,mid-1);

        x.right = buildTree(A,mid+1,end);

        return x;
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
