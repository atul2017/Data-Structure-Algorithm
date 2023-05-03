/*Coin Sum Infinite where order selection matters
Problem Description
You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.

NOTE:

Coins in set A will be unique. Expected space complexity of this problem is O(B).
The answer can overflow. So, return the answer % (106 + 7).

Problem Constraints
1 <= A <= 500
1 <= A[i] <= 1000
1 <= B <= 50000

Input Format
First argument is an integer array A representing the set.
Second argument is an integer B.
Output Format
Return an integer denoting the number of ways.

TC = O(B*Length of A)
SC = O(B)
 */

package DynamicProgramming;
public class CoinSumInfiniteOrderSelection {
    public int coinchange2(int[] A, int B) {
        //this code is for ordered selection where orders matter
             int[] dp = new int[B+1];
             dp[0] =1;
             for(int i=1;i<=B;i++){
                 for(int j =0;j<A.length;j++){
                     if(i>=A[j]){
                         dp[i] = dp[i]+dp[i-A[j]];
                     }
                 }
             }
        return dp[B];
    }
}
