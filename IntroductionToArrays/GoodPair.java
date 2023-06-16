/* Good Pair
Problem Description
Given an array A and an integer B. A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j] == B). Check if any good pair exist or not.
Problem Constraints
1 <= A.size() <= 10^4
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input Format
First argument is an integer array A.
Second argument is an integer B.

Output Format
Return 1 if good pair exist otherwise return 0.

TC = O(N^2)
SC = O(1)
 */

package IntroductionToArrays;

public class GoodPair {
    public int solve(int[] A, int B) {
        int arrayLength = A.length;
        for(int i =0;i<arrayLength;i++){
            for(int j=i+1;j<arrayLength ;j++){
                if(A[i]+A[j]==B ){
                    return 1;
                }
            }
        }
        return 0;
    }
}
