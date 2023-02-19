/* Longest Consecutive Sequence
Problem Description
Given an unsorted integer array A of size N.

Find the length of the longest set of consecutive elements from array A.
Problem Constraints
1 <= N <= 10^6

-10^6 <= A[i] <= 10^6
Input Format
First argument is an integer array A of size N.

Output Format
Return an integer denoting the length of the longest set of consecutive elements from the array A.

TC = O(N)
SC = O(N)

*/


package Hashing;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LongestConsecutiveSeq {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestConsecutive(final List<Integer> A) {
        int min = Collections.min(A);
        int max = Collections.max(A);
        HashSet<Integer> set = new HashSet<>();
        for(int d=0;d<A.size();d++){
            set.add(A.get(d));
        }
        int ans =0;
        int temp =0;
        for(int p=min;p<=max;p++){
            if(set.contains(p)){
                temp++;
            }else{
                ans = Math.max(ans,temp);
                temp=0;
            }
        }
        ans = Math.max(ans,temp);
        return ans;
    }
}
