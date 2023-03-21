/*Sliding Window Maximum
Problem Description
Given an array of integers A. There is a sliding window of size B, moving from the very left of the array to the very right. You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window.
Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].
Refer to the given example for clarity.
NOTE: If B > length of the array, return 1 element with the max of the array.

Problem Constraints
1 <= |A|, B <= 10^6
Input Format
The first argument given is the integer array A.
The second argument given is the integer B.
Output Format
Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].
TC = O(N)
SC = O(B)
 */

package Queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {

        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        if(A.size()==1){
            resultList.add(A.get(0));
            return resultList;
        }

        for(int d=0;d<B;d++){
            while(!queue.isEmpty() && A.get(queue.peekLast())<=A.get(d)){
                queue.removeLast();
            }
            queue.add(d);
        }

        //Max of first subarray
        resultList.add(A.get(queue.peek()));

        for(int p=B;p<A.size();p++){
            while(!queue.isEmpty() && A.get(queue.peekLast())<=A.get(p)){
                queue.removeLast();
            }
            queue.add(p);
            if(queue.peek() == p-B){
                queue.remove();
            }
            //max of each sub array
            resultList.add(A.get(queue.peek()));
        }
        return resultList;
    }
}
