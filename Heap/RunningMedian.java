/*  Running Median
Problem Description
Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.

Find and return the array C.

NOTE:
If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9

Input Format
The only argument given is the integer array A.
Output Format
Return an integer array C, C[i] denotes the median of the first i elements.

TC = O(NlogN)
SC = O(N)
*/

package Heap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> medianList = new ArrayList<>();
        int median =A.get(0);
        for(int d=0;d<A.size();d++){
            if(median>=A.get(d)){
                maxHeap.offer(A.get(d));
                if((maxHeap.size()-minHeap.size())>1){
                    minHeap.offer(maxHeap.poll());
                }
            }else{
                minHeap.offer(A.get(d));
                if(minHeap.size()>maxHeap.size()){
                    maxHeap.offer(minHeap.poll());
                }
            }
            median= maxHeap.peek();
            medianList.add(maxHeap.peek());
        }
        return medianList;
    }

}
