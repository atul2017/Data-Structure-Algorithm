/*Count Rectangles
Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.

Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.

Problem Constraints
1 <= N <= 2000
0 <= A[i], B[i] <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.

Output Format
Return the number of unordered quadruplets that form a rectangle.

TC=O(N)
SC=O(N)
 */

package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CountRectangles {

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        HashMap<Integer, HashSet<Integer>> hashMap = new HashMap<>();
        HashSet<Integer> hashSet;
        int ans = 0;

        //Build the data structure with all the coordinates
        for(int d=0;d<A.size();d++){
            if(hashMap.containsKey(A.get(d))){
                hashSet = hashMap.get(A.get(d));
            }else{
                hashSet = new HashSet<>();
            }
            hashSet.add(B.get(d));
            hashMap.put(A.get(d),hashSet);
        }

        //Check if the traingle exist or now
        for(int p=0;p<A.size();p++){
            for(int r=0;r<A.size();r++){
                if((A.get(p)<A.get(r)) && (B.get(p)<B.get(r)) && hashMap.get(A.get(p)).contains(B.get(r)) && hashMap.get(A.get(r)).contains(B.get(p)) ){
                    ans=ans+1;
                }
            }
        }
        return ans;
    }
}
