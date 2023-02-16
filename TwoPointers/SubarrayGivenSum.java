/* Subarray with given sum
Problem Description
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".

First sub-array means the sub-array for which starting index in minimum.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input Format
The first argument given is the integer array A.

The second argument given is integer B.

Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".

TC = O(N)
SC = O(1)

 */

package TwoPointers;

import java.util.ArrayList;

public class SubarrayGivenSum {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

        int i=0;
        int j=0;
        long sum = A.get(0);

        //List to store the results
        ArrayList<Integer> resultList = new ArrayList<>();

        while(i<A.size()){
            if(sum==B){
                for(int d=i;d<=j;d++){
                    resultList.add(A.get(d));
                }
                return resultList;
            }else if(sum<B){
                j++;
                if(j==A.size()){
                    break;
                }
                sum += A.get(j);
            }else{
                sum -= A.get(i);
                i++;
            }
        }
        resultList.add(-1);
        return resultList;
    }
}
