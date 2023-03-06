/* Longest Palindromic List
Problem Description
Given a linked list of integers. Find and return the length of the longest palindrome list that exists in that linked list.
A palindrome list is a list that reads the same backward and forward.

Expected memory complexity : O(1)

Problem Constraints
1 <= length of the linked list <= 2000
1 <= Node value <= 100

Input Format
The only argument given is head pointer of the linked list.
Output Format
Return the length of the longest palindrome list.

TC = O(N^2)
SC = O(1)
 */



package LinkedList;

public class LongestPalindromeList {
    public int solve(ListNode A) {

        int ans =0;
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = A;

        //The solution is based on three pointers pre->current->next
        while(curr!=null){
            int count =0;
            next = curr.next;
            curr.next = prev;
            //The longest odd palindrome
            count = countMatch(prev,next);
            ans = Math.max(ans, (count*2+1));
            //The longest even palindrome
            count = countMatch(curr,next);
            ans = Math.max(ans, count*2);
            prev = curr;
            curr = next;
        }
        return ans;
    }

    //count the number of nodes which satisfies the condition of the palindrome
    int countMatch(ListNode node1, ListNode node2){
        int count =0;
        while(node1!=null && node2!=null){
            if(node1.val==node2.val){
                count++;
            }else{
                break;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return count;
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
