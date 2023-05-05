/*Cutting a Rod
Problem Description
Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.
Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.
Problem Constraints
1 <= N <= 1000
0 <= A[i] <= 10^6
Input Format
First and only argument is an integer array A of size N.
Output Format
Return an integer denoting the maximum value that can be obtained by cutting up the rod and selling the pieces.

TC = O(N^2) where N is the number of elements
SC = O(N)

 */


package DynamicProgramming;

public class CuttingARod {
    public int solve(int[] A) {
        int N = A.length;
        int[] dp = new int[N+1];
        for(int i=0;i<=N;i++){
            for(int j=0;j<i;j++){
                dp[i] = Math.max(dp[i],A[j]+dp[i-j-1]);
            }
        }
        return dp[N];
    }
}
