/*
Problem Description
You are given an array A of length N and Q queries given by the 2D array B of size Q×2.

Each query consists of two integers B[i][0] and B[i][1].

For every query, your task is to find the count of even numbers in the range from A[B[i][0]] to A[B[i][1]].

Problem Constraints
1 <= N <= 10^5
1 <= Q <= 10^5
1 <= A[i] <= 10^9
0 <= B[i][0] <= B[i][1] < N

Input Format
First argument A is an array of integers.
Second argument B is a 2D array of integers.
Output Format
Return an array of integers.

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = [   [0, 2]
        [2, 4]
        [1, 4]   ]
Input 2:
A = [2, 1, 8, 3, 9, 6]
B = [   [0, 3]
        [3, 5]
        [1, 3]
        [2, 4]   ]
Example Output
Output 1:
[1, 1, 2]
Output 2:
[2, 1, 1, 1]

TC = O(N)
SC = O(N)
*/


package ArraysTechniques;
public class EvenNumbersInARange {
    public int[] solve(int[] A, int[][] B) {
        int[] pfx = new int[A.length];
        int[] finalArray = new int[B.length];

        pfx[0] = 1 - (A[0]%2);

        for(int j=1;j<A.length;j++){
            pfx[j]=pfx[j-1] + (1 - A[j]%2);
        }

        for(int k=0;k<B.length;k++){
            int l = B[k][0];
            int r = B[k][1];
            if(l==0){
                finalArray[k] = pfx[r];
            }else{
                finalArray[k] = pfx[r]-pfx[l-1];
            }
        }
        return finalArray;
    }
}
