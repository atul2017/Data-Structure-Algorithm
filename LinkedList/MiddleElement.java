/*Middle element of linked list
Problem Description
Given a linked list of integers, find and return the middle element of the linked list.

NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.

Problem Constraints
1 <= length of the linked list <= 100000

1 <= Node value <= 10^9

Input Format
The only argument given head pointer of linked list.

Output Format
Return the middle element of the linked list.

TC = O(N)
SC = O(1)

 */


package LinkedList;

public class MiddleElement {

    public class Solution {
        public int solve(ListNode A) {
            ListNode slowPointer = A;
            ListNode fastPointer = A;
            while(fastPointer!=null && fastPointer.next!=null){
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
            return slowPointer.val;
        }
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