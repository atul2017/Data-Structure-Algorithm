/*  Leaders in an array
Problem Description
Given an integer array A containing N distinct integers, you have to find all the leaders in array A. An element is a leader if it is strictly greater than all the elements to its right side.
NOTE: The rightmost element is always a leader.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^8
Input Format
There is a single input argument which a integer array A
Output Format
Return an integer array denoting all the leader elements of the array.
Example Input
Input 1:
A = [16, 17, 4, 3, 5, 2]
Input 2:
A = [5, 4]

Example Output
Output 1:
[17, 2, 5]
Output 2:
[5, 4]

TC = O(N)
SC = O(1)
 */

package ArraysTechniques;

import java.util.ArrayList;

public class LeadersInArray {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int size = A.size();
        int max = A.get(size-1);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(A.get(size-1));
        for(int i=size-2; i>=0; i--){
            if(max < A.get(i)){
                max = A.get(i);
                ans.add(max);
            }
        }
        return ans;
    }
}
