/* Maximum XOR
Problem Description
Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.
Problem Constraints
1 <= length of the array <= 100000
0 <= A[i] <= 10^9
Input Format
The only argument given is the integer array A.
Output Format
Return an integer denoting the maximum result of A[i] XOR A[j].

TC=O(N)
SC=O(N*H)~O(N)
*/


package Tries;

import java.util.ArrayList;

public class MaximumXOR {
    public int solve(ArrayList<Integer> A) {
        TrieNode root = new TrieNode();
        for (int d = 0; d < A.size(); d++) {
            TrieNode temp = root;
            for (int p = 31; p >= 0; p--) {
                int b = (A.get(d) >> p) & 1;
                if (b == 0) {
                    if (temp.left == null) {
                        temp.left = new TrieNode();
                    }
                    temp = temp.left;
                } else {
                    if (temp.right == null) {
                        temp.right = new TrieNode();
                    }
                    temp = temp.right;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int r = 0; r < A.size(); r++) {
            TrieNode current = root;
            int sum = 0;
            for (int a = 31; a >= 0; a--) {
                int b = (A.get(r) >> a) & 1;
                if (b == 0) {
                    if (current.right != null) {
                        sum += (1 << a);
                        current = current.right;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.left != null) {
                        sum += (1 << a);
                        current = current.left;
                    } else {
                        current = current.right;
                    }
                }
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
class TrieNode{
    TrieNode left ; //left points to zero
    TrieNode right ; //right points to zero
    TrieNode(){
        left = null;
        right = null;
    }
}

