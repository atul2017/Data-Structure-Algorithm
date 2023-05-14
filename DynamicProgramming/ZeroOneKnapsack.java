/* 0-1 Knapsack
Problem Description
Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
Also given an integer C which represents knapsack capacity.
Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
NOTE:
You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
Problem Constraints
1 <= N <= 10^3
1 <= C <= 10^3
1 <= A[i], B[i] <= 10^3

Input Format
First argument is an integer array A of size N denoting the values on N items.
Second argument is an integer array B of size N denoting the weights on N items.
Third argument is an integer C denoting the knapsack capacity.
Output Format
Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

TC = O(N*C) where N is number of happiness and C is the Knapsack capacity
SC= O(C)
*/

package DynamicProgramming;

public class ZeroOneKnapsack {
    public int solve(int[] A, int[] B, int C) {
        int N = A.length;
        int W = C;
        int[][] dp = new int[N+1][W+1];

        for(int i=0;i<N;i++){
            for(int j=0;j<=W;j++){
                if(B[i]>j){
                    dp[i+1][j] = dp[i][j];
                }else{
                    dp[i+1][j] = Math.max(dp[i][j-B[i]]+A[i],dp[i][j]);
                }
            }
        }
        return dp[N][W];
    }
}
