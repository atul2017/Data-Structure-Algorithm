/*Ath Largest element
Problem Description
Given an integer array B of size N.
You need to find the Ath largest element in the subarray [1 to i], where i varies from 1 to N. In other words, find the Ath largest element in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].
NOTE: If any subarray [1 : i] has less than A elements, then the output should be -1 at the ith index.
Problem Constraints
1 <= N <= 100000
1 <= A <= N
1 <= B[i] <= INT_MAX
Input Format
The first argument is an integer A.
The second argument is an integer array B of size N.
Output Format
Return an integer array C, where C[i] (1 <= i <= N) will have the Ath largest element in the subarray [1 : i].

TC =O(NlogA)
SC = O(A)
 */

package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class AthLargestElement {
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        for(int d=0;d<A;d++){
            pq.add(B.get(d));
        }
        for(int p=0;p<A-1;p++){
            resultList.add(-1);
        }
        resultList.add(pq.peek());
        for(int r=A;r<B.size();r++){
            if(B.get(r)>pq.peek()){
                pq.poll();
                pq.add(B.get(r));
            }
            resultList.add(pq.peek());
        }
        return resultList;
    }
}
