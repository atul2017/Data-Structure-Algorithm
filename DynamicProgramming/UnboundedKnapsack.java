/*Unbounded Knapsack
Problem Description
Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.
This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
Problem Constraints
1 <= A <= 1000
1 <= |B| <= 1000
1 <= B[i] <= 1000
1 <= C[i] <= 1000
Input Format
First argument is the Weight of knapsack A
Second argument is the vector of values B
Third argument is the vector of weights C
Output Format
Return the maximum value that fills the knapsack completely

TC = O(A*Number of items) or O(A*Length of B or C array) where A is the given capacity
SC= O(A)
*/

package DynamicProgramming;

public class UnboundedKnapsack {
    public int solve(int A, int[] B, int[] C) {
        int[] dp = new int[A+1];
        for(int i=0;i<=A;i++){
            for(int j=0;j<B.length;j++){
                if(i>=C[j]){
                    dp[i] = Math.max(dp[i],B[j]+dp[i-C[j]]);
                }
            }
        }
        return dp[A];
    }
}
