/*Sub-array with 0 sum

Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
If the given array contains a sub-array with sum zero return 1, else return 0.

Problem Constraints
1 <= |A| <= 100000
-10^9 <= A[i] <= 10^9
Input Format
The only argument given is the integer array A.
Output Format
Return whether the given array contains a subarray with a sum equal to 0.

TC = O(N)
SC = O(N)
 */

package Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class SubAarrayWithZeroSum {
    public int solve(ArrayList<Integer> A) {
        ArrayList<Long> pfxSum = new ArrayList<>();
        pfxSum.add((long)A.get(0));
        for(int d=1;d<A.size();d++){
            long temp = pfxSum.get(d-1)+A.get(d);
            pfxSum.add(temp);
        }
        if(pfxSum.contains((long)0)){
            return 1;
        }
        HashMap<Long,Integer> map = new HashMap<>();

        for(int p=0;p<pfxSum.size();p++){
            if(map.get(pfxSum.get(p))==null){
                map.put(pfxSum.get(p),p);
            }else{
                return 1;
            }
        }
        return 0;
    }
}
