/*Merge Two Sorted Lists
Problem Description
Merge two sorted linked lists, A and B, and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists and should also be sorted.

Problem Constraints
0 <= |A|, |B| <= 10^5
Input Format
The first argument of input contains a pointer to the head of linked list A.
The second argument of input contains a pointer to the head of linked list B.

Output Format
Return a pointer to the head of the merged linked list.
TC = O(Length of list A+Length of list B) = O(N+M)
SC = 0(1)
*/


package LinkedList;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {

        //edge cases
        if(A==null){
            return B;
        }
        if(B==null){
            return A;
        }

        ListNode head;
        //find the head
        if(A.val<B.val){
            head = A;
            A = A.next;
        }else{
            head = B;
            B = B.next;
        }

        ListNode temp = head;
        while(A!=null && B!=null){
            if(A.val<B.val){
                temp.next = A;
                A = A.next;
            }else{
                temp.next = B;
                B= B.next;
            }
            temp=temp.next;
        }

        //At least on the list have been exhausted
        if(A!=null){
            temp.next = A;
        }
        if(B!=null){
            temp.next = B;
        }
        return head;
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

