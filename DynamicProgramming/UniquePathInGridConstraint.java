/* Unique Paths in a Grid
Problem Description
Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m). At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and empty space is marked as 1 and 0 respectively in the grid.
Problem Constraints
1 <= n, m <= 100
A[i][j] = 0 or 1
Input Format
Firts and only argument A is a 2D array of size n * m.
Output Format
Return an integer denoting the number of unique paths from (1, 1) to (n, m).

TC = O(N*M)
SC = O(N*M)


 */
package DynamicProgramming;

public class UniquePathInGridConstraint {
    public int uniquePathsWithObstacles(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] dp = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(A[i][j]==1){
                    dp[i][j] = 0;
                }else if(i==0 && j==0){
                    dp[i][j] = 1;
                }else{
                    int up =0;
                    int left =0;
                    if(i>0){up = dp[i-1][j];}
                    if(j>0){left = dp[i][j-1];}
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[row-1][col-1];
    }
}
