/* Copy List
Problem Description
A linked list A is given such that each node contains an additional random pointer which could point to any node in the list or NULL.
Return a deep copy of the list.

Problem Constraints
0 <= |A| <= 10^6
Input Format
The first argument of input contains a pointer to the head of linked list A.
Output Format
Return a pointer to the head of the required linked list.
TC = O(N)
SC = O(1)
 */

package LinkedList;

public class CopyList {
    public RandomListNode copyRandomList(RandomListNode head) {

        if(head==null){
            return null;
        }

        //copy every node and insert in the list
        RandomListNode tempHead = head;
        while(tempHead!=null){
            RandomListNode y = new RandomListNode(tempHead.label);
            y.next = tempHead.next;
            tempHead.next = y;
            tempHead = y.next;
        }

        //assign the random pointers to deep copy
        RandomListNode tempHead1 = head;
        while(tempHead1!=null){
            if(tempHead1.random!=null){
                tempHead1.next.random = tempHead1.random.next;
            }
            tempHead1 = tempHead1.next.next;
        }

        //Separate the linked list and return the deep copy linked list
        RandomListNode head2 = head.next;
        RandomListNode x = head;
        RandomListNode y = head.next;
        while(x!=null){
            x.next = x.next.next;
            if(y.next!=null){
                y.next=y.next.next;
            }
            x=x.next;
            y=y.next;
        }
        return head2;
    }
}
 //Definition for singly-linked list with a random pointer.
  class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };
