/*Sorted Insert Position
Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
If not, return the index where it would be if it were inserted in order.

NOTE: You may assume no duplicates in the array. Users are expected to solve this in O(log(N)) time.

Problem Constraints - 1 <= N <= 10^6

Input Format -
The first argument is an integer array A of size N.
The second argument is an integer B.

Output Format -
Return an integer denoting the index of target value.

TC=O(logN)
SC= O(1)

 */

package Sorting;

public class BinarySearchAlgorithm {
    public int searchInsert(ArrayList<Integer> A, int B) {

        int start =0;
        int end = A.size()-1;
        int mid = 0;
        if(A.size()==1){
            if(A.get(0)==B){
                return 0;
            }
        }
        while(start<=end){
            mid = (start+end)/2;
            if(A.get(mid)==B){
                return mid;
            }else if(A.get(mid)>B){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return end+1;
    }
}
