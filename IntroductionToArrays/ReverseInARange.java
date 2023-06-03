/*Reverse in a range
Problem Description
Given an array A of N integers and also given two integers B and C. Reverse the elements of the array A within the given inclusive range [B, C].

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^9
0 <= B <= C <= N - 1

Input Format
The first argument A is an array of integer.
The second and third arguments are integers B and C
Output Format
Return the array A after reversing in the given range.

SC = O(1)
TC = O(N)
 */



package IntroductionToArrays;

public class ReverseInARange {
    public int[] solve(int[] A, int B, int C) {
        while(B<C){
            int tempVariable = A[B];
            A[B] = A[C];
            A[C] = tempVariable;
            B++;
            C--;
        }
        return A;
    }
}
