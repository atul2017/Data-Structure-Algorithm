/*Remove Loop from Linked List
Problem Description
You are given a linked list that contains a loop.
You need to find the node, which creates a loop and break it by making the node point to NULL.

Problem Constraints
1 <= number of nodes <= 1000
Input Format
The first of the input contains a LinkedList, where the first number is the number of nodes N, and the next N nodes are the node value of the linked list.
The second line of the input contains an integer which denotes the position of node where cycle starts.
Output Format
return the head of the updated linked list.
TC = O(N)
SC = O(N)
*/


package LinkedList;

import java.util.HashSet;

public class RemoveLoopFromList {
    public ListNode solve(ListNode A) {

        //This data structure will maintain the nodes which are visited
        //this approach will take SC O(N)
        HashSet<ListNode> vistedNodes = new HashSet<>();
        ListNode head = A;
        while(head!=null){
            if(!vistedNodes.contains(head.next)){
                head = head.next;
                vistedNodes.add(head);
            }else{
                head.next= null;
            }
        }
        return A;
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
