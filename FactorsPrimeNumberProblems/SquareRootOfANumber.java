/*Square root of a number
Problem Description
Given a number A. Return square root of the number if it is perfect square otherwise return -1.
Problem Constraints

1 <= A <= 10^8
Input Format
First and the only argument is an integer A.
Output Format
Return an integer which is the square root of A if A is perfect square otherwise return -1.
Example Input

Input 1:
A = 4
Input 2:
A = 1001
Example Output
Output 1:
2
Output 2:
-1

TC = O(1) //The loop runs constant time of 10000 times
SC = O(1)

 */

package FactorsPrimeNumberProblems;

public class SquareRootOfANumber {
    public int solve(int A) {
        int j = -1;
        if(A==1){
            return A;
        }
        for(int i=1; i<=10000; i++){
            if(i*i==A){
                return i;
            }
        }
        return j;
    }
}
