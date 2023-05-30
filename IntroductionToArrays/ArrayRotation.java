/*Array Rotation
Problem Description
Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <=10^9
1 <= B <= 10^9


Input Format
The first argument given is the integer array A.
The second argument given is the integer B.
Output Format
Return the array A after rotating it B times to the right

SC = O(1)
TC = O(N)

 */

package IntroductionToArrays;

public class ArrayRotation {
    public int[] solve(int[] A, int B) {
        int i = 0;
        int j = A.length -1;

        //This condition checks if number of rotation is equal to size of the array
        //In this case if you rotate the array, you will the original array again
        if(B%A.length == 0){
            return A;
        }
        else{
            B = B%A.length;
        }

        //Reverse the array
        while (i<j){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }

        //Reverse the array from 0 to B-1
        i = 0;
        j = B-1;
        while (i<j){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }

        //reverse the array from B to N-1
        i = B;
        j = A.length-1;
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
