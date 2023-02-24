/*Count Right Triangles
Problem Description
Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.

Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.

NOTE: The answer may be large so return the answer modulo (109 + 7).
Problem Constraints
1 <= N <= 10^5
0 <= A[i], B[i] <= 10^9
Input Format
The first argument given is an integer array A.
The second argument given is the integer array B.

Output Format
Return the number of unordered triplets that form a right angled triangle modulo (109 + 7).

TC=O(N)
SC=O(N)

 */


package Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class CountRightTriangles {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        HashMap<Integer,Integer> aFrequencyMap = new HashMap<>();
        HashMap<Integer,Integer> bFrequencyMap = new HashMap<>();

        for(int d=0;d<A.size();d++){
            if(aFrequencyMap.get(A.get(d))==null){
                aFrequencyMap.put(A.get(d),1);
            }else{
                int temp = aFrequencyMap.get(A.get(d)) + 1;
                aFrequencyMap.put(A.get(d),temp);
            }
        }

        for(int p=0;p<A.size();p++){
            if(bFrequencyMap.get(B.get(p))==null){
                bFrequencyMap.put(B.get(p),1);
            }else{
                int temp = bFrequencyMap.get(B.get(p)) + 1;
                bFrequencyMap.put(B.get(p),temp);
            }
        }

        long ans =0;
        for(int r=0;r<A.size();r++){
            long tempAns = (aFrequencyMap.get(A.get(r)) - 1) * (bFrequencyMap.get(B.get(r)) - 1);
            ans = ans + tempAns;
        }
        return (int) (ans%1000000007);
    }
}
