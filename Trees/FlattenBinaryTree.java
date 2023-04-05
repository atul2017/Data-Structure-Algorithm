/*Flatten Binary Tree to Linked List
Problem Description
Given a binary tree A, flatten it to a linked list in-place.
The left child of all nodes should be NULL.

Problem Constraints
1 <= size of tree <= 100000
Input Format
First and only argument is the head of tree A.
Output Format
Return the linked-list after flattening.

TC = O(N)
SC = O(H)
 */


package Trees;

public class FlattenBinaryTree {
    public TreeNode flatten(TreeNode a) {
        flatten1(a);
        return a;
    }

    Pair flatten1(TreeNode root){
        Pair p = new Pair();
        if(root==null){
            p.head = null;
            p.tail = null;
            return p;
        }
        Pair L = flatten1(root.left);
        Pair R = flatten1(root.right);
        root.left =null;
        if(L.head==null && R.head ==null){
            p.head = root;
            p.tail = root;
            return p;
        }else if(L.head==null){
            root.right = R.head;
            p.head = root;
            p.tail = R.tail;
            return p;
        }else if(R.head==null){
            root.right = L.head;
            p.head=root;
            p.tail = L.tail;
            return p;
        }else{
            root.right = L.head;
            L.tail.right = R.head;
            p.head = root;
            p.tail = R.tail;
            return p;
        }
    }
}
class Pair{
    TreeNode head;
    TreeNode tail;
    Pair(){
        head = null;
        tail = null;
    }
}

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */