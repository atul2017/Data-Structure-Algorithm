/*Dungeon Princess
Problem Description
The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
Given a 2D array of integers A of size M x N. Find and return the knight's minimum initial health so that he is able to rescue the princess.

Problem Constraints
1 <= M, N <= 500
-100 <= A[i] <= 100
Input Format
First and only argument is a 2D integer array A denoting the grid of size M x N.
Output Format
Return an integer denoting the knight's minimum initial health so that he is able to rescue the princess.

TC =O(M*N)
SC = O(M*N) + Stack call which will be O(M+N) and negligible in analysis = O(N*M)
 */


package DynamicProgramming;

public class DungeonPrincess {
    int[][] dp = null;
    int row =0;
    int col =0;
    public int calculateMinimumHP(int[][] A) {
        row = A.length;
        col = A[0].length;
        dp = new int[row][col];
        for(int d=0;d<row;d++){
            for(int p=0;p<col;p++){
                dp[d][p] = -1;
            }
        }
        return minHealth(A,0,0);
    }

    int minHealth(int[][] A,int m, int n){
        if(m>=row || n>=col){
            return Integer.MAX_VALUE;
        }
        if(m==row-1 && n==col-1){
            return Math.max(1,1-A[m][n]);
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int x = minHealth(A,m+1,n);
        int y = minHealth(A,m,n+1);
        dp[m][n] = Math.max(Math.min(x,y)-A[m][n],1);
        return Math.max(Math.min(x,y)-A[m][n],1);
    }
}
