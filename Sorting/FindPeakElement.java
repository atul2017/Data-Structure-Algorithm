/*Find a peak element
Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.

NOTE: Users are expected to solve this in O(log(N)) time. The array may have duplicate elements.

Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return the peak element.

TC=O(logN)
SC=O(1)

 */

package Sorting;

import java.util.ArrayList;

public class FindPeakElement {
    public int solve(ArrayList<Integer> A) {
        int start = 0;
        int end = A.size()-1;
        int mid =0 ;
        while(start<=end){
            mid = (start+end)/2;
            if( (mid==0 || A.get(mid)>A.get(mid-1)) && (mid==A.size()-1 || A.get(mid)>A.get(mid+1))){
                return A.get(mid);
            }
            if(mid==0 || A.get(mid)>A.get(mid-1)){
                start= mid+1;
            }else{
                end = mid-1;
            }
        }
        return A.get(mid);
    }
}
