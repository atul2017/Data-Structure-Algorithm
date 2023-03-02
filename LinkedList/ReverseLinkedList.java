/* Reverse Linked List
Problem Description
You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.

NOTE: You have to do it in-place and in one-pass.

Problem Constraints
1 <= Length of linked list <= 105

Value of each node is within the range of a 32-bit integer.
Input Format
First and only argument is a linked-list node A.
Output Format
Return a linked-list node denoting the head of the reversed linked list.

TC = O(N)
SC = O(1)

 */
/*
 * Definition for singly-linked list.
 */

package LinkedList;
 class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
 }
 public class ReverseLinkedList {
    public ListNode reverseList(ListNode A) {

        //Three pointers current = A, prev and next
        //Initially prev assigned to null
        ListNode prev = null;
        //Initially current assigned to head which is A
        ListNode current = A;

        while(current != null){
            ListNode next = current.next;
            current.next= prev;
            prev=current;
            current=next;
        }
        A = prev;
        return A;
    }
}
