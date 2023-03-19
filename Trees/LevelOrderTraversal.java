/*Level Order Traversal
Problem Description
Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
Problem Constraints
1 <= number of nodes <= 10^5
Input Format
First and only argument is root node of the binary tree, A.
Output Format
Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.

TC = O(N)
SC = O(N)

 */

package Trees;

import java.util.ArrayList;

public class LevelOrderTraversal {

    Queue frontPointer = null;
    Queue rearPointer = null;
    int numberofNodes =  0;

    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {

        if(A==null){
            return null;
        }
        LevelOrderTraversal solutionObject = new LevelOrderTraversal();

        //enter the root of the tree
        solutionObject.enqueue(A);

        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

        //Enter the root as the last item
        TreeNode last = A;

        ArrayList<Integer> temp = new ArrayList<>();

        while(!solutionObject.isEmpty()){
            //Dequeue the node
            TreeNode node =solutionObject.dequeue().node;
            temp.add(node.val);
            if(node.left!=null){
                solutionObject.enqueue(node.left);
            }
            if(node.right!=null){
                solutionObject.enqueue(node.right);
            }
            //if node is the last in the level-we need to add the arraylist
            if(node==last){
                resultList.add(temp);
                if(solutionObject.rear()!=null){
                    last = solutionObject.rear().node;
                }
                temp = new ArrayList<>();
            }
        }
        return resultList;
    }

    //Enqueue item in the rear of the queue
    void enqueue(TreeNode data) {
        Queue node = new Queue(data);
        if(rearPointer==null){
            rearPointer = node;
            frontPointer = node;
            numberofNodes++;
        }else{
            node.next = rearPointer;
            rearPointer = node;
            numberofNodes++;
        }
    }
    //dequeue item in the front of queue
    Queue dequeue() {
        Queue tempTraverseNode = null;
        Queue nodeToReturn = null;
        if(frontPointer==null) {
            System.out.println("Queue is Empty");
        }else if(frontPointer==rearPointer){
            tempTraverseNode = frontPointer;
            rearPointer =null;
            frontPointer = null;
            numberofNodes--;
            return tempTraverseNode;
        }else{
            tempTraverseNode = rearPointer;
            int i =1;
            while(i<=numberofNodes){
                if(i==numberofNodes-1){
                    frontPointer = tempTraverseNode;
                    nodeToReturn =tempTraverseNode.next;
                    tempTraverseNode.next = null;
                    numberofNodes--;
                    break;
                }
                i++;
                tempTraverseNode = tempTraverseNode.next;
            }
        }
        return nodeToReturn;
    }
    Queue rear(){
        if(rearPointer!=null){
            return rearPointer;
        }
        return null;
    }

    boolean isEmpty() {
        if(rearPointer==null){
            return true;
        }
        return false;
    }
}
//Definition of Queue
class Queue{
    TreeNode node;
    Queue next;
    Queue(TreeNode data){
        this.node = data;
        next = null;
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