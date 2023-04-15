/*Merge K Sorted Lists

Problem Description
Given a list containing head pointers of N sorted linked lists.
Merge these given sorted linked lists and return them as one sorted list.
Problem Constraints
1 <= total number of elements in given linked lists <= 100000
Input Format
The first and only argument is a list containing N head pointers.
Output Format
Return a pointer to the head of the sorted linked list after merging all the given linked lists.

TC=O(N*K*logK)
SC=O(K)
 */

package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLinkedLists {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        //Create the priority queue and insert elements from all the linked lists
        Queue<Integer> pq = new PriorityQueue<>();
        for(int d=0;d<a.size();d++){
            ListNode tempList = a.get(d);
            while(tempList!=null){
                pq.add(tempList.val);
                tempList = tempList.next;
            }
        }
        //Create a new linked list and insert all elements from the priority queue
        ListNode head = new ListNode(pq.poll());
        ListNode curr = head;
        while(pq.size()>0){
            ListNode temp = new ListNode(pq.poll());
            curr.next = temp;
            curr= curr.next;
        }
        return  head;
    }
}
/**
 * Definition for singly-linked list.*/
 class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

