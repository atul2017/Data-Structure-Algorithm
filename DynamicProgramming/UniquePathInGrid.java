/* Unique path in a grid - Number of unique ways to go from (0,0)->(N-1,M-1) cell of grid of size NXM

Allowed movements are L->R and Bottom->Down

TC = O(N*M)
SC = O(N*M) + Stack Trace which is N+M and it is negligible
*/


package DynamicProgramming;

public class UniquePathInGrid {
    int[][] dp = null;
    int row = 0;
    int col = 0;
    public int uniquePathsWithObstacles(int[][] A) {
        row = A.length;
        col = A[0].length;
        if(row==1 && col ==1){
            if(A[row-1][col-1]==1){
                return 0;
            }else{
                return 1;
            }
        }
        dp = new int[row][col];
        for(int d=0;d<row;d++){
            for(int p=0;p<col;p++){
                dp[d][p] = -1;
            }
        }
        // if(A[0][0]==0){
        //     dp[0][0]=1;
        // }
        numberOfWays(row-1,col-1,A);
        return dp[row-1][col-1];
    }
    int numberOfWays(int m,int n,int[][] A){
        // if(m<0 || n<0){
        //     return 0;
        // }
        if(m==0 || n==0){
            return 1;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }

        // if(A[m][n]==1){
        //     return dp[m][n]=0;
        // }
        int x = numberOfWays(m-1,n,A);
        int y = numberOfWays(m,n-1,A);
        dp[m][n] = x+y;
        return dp[m][n];
    }
}
