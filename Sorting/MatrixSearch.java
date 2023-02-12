/* Matrix Search
Problem Description
Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

NOTE: Rows are numbered from top to bottom, and columns are from left to right.

Problem Constraints
1 <= N, M <= 1000
1 <= A[i][j], B <= 10^6

Input Format
The first argument given is the integer matrix A.
The second argument given is the integer B.

Output Format
Return 1 if B is present in A else, return 0.

TC = O(N)
SC = O(1)
 */

package Sorting;

import java.util.ArrayList;

public class MatrixSearch {
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int startIndex =0;
        int lastIndex =0;
        ArrayList<Integer> tempResult = new ArrayList<>();
        for(int d=0;d<A.size();d++){
            tempResult = A.get(d);
            if(tempResult.get(tempResult.size()-1)==B){
                return 1;
            }else if(tempResult.get(tempResult.size()-1)<B){
                startIndex = d+1;
            }else{
                lastIndex = d;
            }
        }
        for(int p=startIndex;p<=lastIndex;p++){
            tempResult = A.get(p);
            for(int r=0;r<tempResult.size();r++){
                if(tempResult.get(r)==B){
                    return 1;
                }
            }
        }
        return 0;
    }
}
