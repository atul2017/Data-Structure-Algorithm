/*Connect ropes
Problem Description
You are given an array A of integers that represent the lengths of ropes.
You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
Find and return the minimum cost to connect these ropes into one rope.

Problem Constraints
1 <= length of the array <= 10^6
1 <= A[i] <= 10^9
Input Format
The only argument given is the integer array A.
Output Format
Return an integer denoting the minimum cost to connect these ropes into one rope.

TC = o(NlogN)
SC = o(N)
 */


package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectRopesWithDiffConstraints {
    public Long solve(ArrayList<Integer> A) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int d=0;d<A.size();d++){
            pq.offer((long)A.get(d));
        }
        long ans =0;
        while(pq.size()>1){
            long result = pq.poll() + pq.poll();
            ans += (result);
            pq.offer(result);
        }
        return ans;
    }
}
