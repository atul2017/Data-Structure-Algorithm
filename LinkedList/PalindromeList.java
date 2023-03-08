/*Palindrome List
Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
Problem Constraints
1 <= |A| <= 10^5
Input Format-
The first and the only argument of input contains a pointer to the head of the given linked list.
Output Format-
Return 0, if the linked list is not a palindrome.
Return 1, if the linked list is a palindrome.

TC=O(N)
SC=O(N)
 */

package LinkedList;

import java.util.ArrayList;
import java.util.Collections;

public class PalindromeList {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */
    public class Solution {
        public int lPalin(ListNode A) {
            ArrayList<Integer> number = new ArrayList<>();
            while(A!=null){
                number.add(A.val);
                A = A.next;
            }
            ArrayList<Integer> reverseList = new ArrayList(number);
            Collections.reverse(reverseList);
            if(reverseList.equals(number)){
                return 1;
            }else{
                return 0;
            }
        }
    }
}
