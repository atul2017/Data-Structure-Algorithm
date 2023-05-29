/*Reverse the array
Problem Description
You are given a constant array A.
You are required to return another array which is the reversed form of the input array.

Problem Constraints
1 <= A.size() <= 10000
1 <= A[i] <= 10000

Input Format
First argument is a constant array A.
Output Format
Return an integer array.

SC = 0(1)
TC = O(N)
 */


package IntroductionToArrays;

public class ReverseTheArray {
    public int[] solve(final int[] A) {
        int i = 0;
        int j = A.length -1;
        while (i<j){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
        return A;
    }
}
