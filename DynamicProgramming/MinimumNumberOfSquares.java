/*Minimum Number of Squares
Problem Description
Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
Problem Constraints
1 <= A <= 10^5
Input Format
First and only argument is an integer A.
Output Format
Return an integer denoting the minimum count.

TC=O(NsqrtN)
SC=O(N)
*/

package DynamicProgramming;

public class MinimumNumberOfSquares {
    public int countMinSquares(int A) {
        int[] ans = new int[A+1];
        for(int d=0;d<=A;d++){
            ans[d] = Integer.MAX_VALUE;
        }
        ans[0] = 0;
        for(int i=1;i<=A;i++){
            for(int x=1;x*x<=i;x++){
                ans[i]= Math.min(ans[i],ans[i-x*x]+1);
            }
        }
        return ans[A];
    }
}
