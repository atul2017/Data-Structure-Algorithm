/*Magician and Chocolates
Problem Description
Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the ith bag with floor(Bi/2) chocolates.
Find the maximum number of chocolates that the kid can eat in A units of time.
NOTE:
floor() function returns the largest integer less than or equal to a given number.
Return your answer modulo 10^9+7

Problem Constraints
1 <= N <= 100000
0 <= B[i] <= INT_MAX
0 <= A <= 10^5
Input Format
The first argument is an integer A.
The second argument is an integer array B of size N.
Output Format
Return an integer denoting the maximum number of chocolates the kid can eat in A units of time.

TC= O(NlogN)
SC= O(N)

 */

package Heap;

import java.util.*;

public class MagicianChocolates {
    public int nchoc(int A, ArrayList<Integer> B) {
        Queue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int d=0;d<B.size();d++){
            pq.add((long)B.get(d));
        }
        long ans = 0;
        while(A>0){
            long chocCount = pq.poll();
            ans = ans + chocCount;
            long insertChocCount = (long)Math.floor(chocCount/2);
            pq.add(insertChocCount);
            A--;
        }
        return (int)(ans%1000000007);
    }
}
