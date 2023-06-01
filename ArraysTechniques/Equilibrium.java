/* Equilibrium index of an array
Problem Description
You are given an array A of integers of size N.
Your task is to find the equilibrium index of the given array
The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.

Note:
Array indexing starts from 0.
If there is no equilibrium index then return -1.
If there are more than one equilibrium indexes then return the minimum index.

Problem Constraints
1 <= N <= 10^5
-105 <= A[i] <= 10^5

Input Format
First arugment is an array A .
Output Format
Return the equilibrium index of the given array. If no such index is found then return -1.

TC = O(N)
SC = O(1) //I am using the same array to store the prefix values

 */

package ArraysTechniques;

public class Equilibrium {
    public int solve(int[] A) {
        //Prefix sum array
        for(int i=1;i<A.length;i++){
            A[i] = A[i-1]+A[i];
        }
        int arrayLength = A.length;
        for(int j=0;j<arrayLength;j++){
            if(j==0){
                if(A[arrayLength-1]-A[0]==0){
                    return 0;
                }
                continue;
            }
            if(A[j-1]==(A[arrayLength-1]-A[j])){
                return j;
            }
        }
        return -1;
    }
}
