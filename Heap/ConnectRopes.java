/*Connect ropes
Problem Description
You are given an array A of integers that represent the lengths of ropes.
You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
Find and return the minimum cost to connect these ropes into one rope.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 1000
Input Format
The only argument given is the integer array A.
Output Format
Return an integer denoting the minimum cost to connect these ropes into one rope.

TC = o(nlogn)
SC = o(n)
 */

package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConnectRopes {
    public int solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int d=0;d<A.size();d++){
            pq.add(A.get(d));
        }
        int ans = 0;
        while(pq.size()>1){
            int firstElement = pq.poll();
            int secondElement = pq.poll();
            ans += (firstElement+secondElement);
            pq.add(firstElement+secondElement);
        }
        return ans;
    }
}
