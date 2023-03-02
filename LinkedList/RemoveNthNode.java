/*Remove Nth Node from List End
Problem Description

Given a linked list **A**, remove the **B-th** node from the end of the list and return its head. For example, Given linked list: `1->2->3->4->5`, and `B = 2`. After removing the second node from the end, the linked list becomes `1->2->3->5`. **NOTE:** If **B** is greater than the size of the list, remove the first node of the list. **NOTE:** Try doing it using constant additional space.
Problem Constraints

1 <= |A| <= 10^6
Input Format

The first argument of input contains a pointer to the head of the linked list. The second argument of input contains the integer B.
Output Format

Return the head of the linked list after deleting the B-th element from the end.

TC = O(N)
SC = O(1)

 */


package LinkedList;

public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode A, int B) {

        ListNode head = A;
        int k =0;

        //if there is only one node in the list
        if(head.next==null){
            return null;
        }

        head = A;
        //find out length of the linked list
        while(head!=null){
            head = head.next;
            k++;
        }

        //if B is greater than the list - remove the first node and return the list
        if(B>k){
            A = A.next;
            return A;
        }

        //element at Bth position
        int position = k-B;
        int i=1;
        head =A;

        //if the Bth position is the first element
        if(position==0){
            ListNode temp = head.next;
            head = temp;
            temp = null;
            return head;
        }

        //if the Bth position is last or middle element
        while(i<position){
            head = head.next;
            i++;
        }
        ListNode temp = head.next;
        head.next = temp.next;
        //head.next=null;
        return A;
    }
}
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
