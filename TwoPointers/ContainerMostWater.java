/*Container With Most Water
Problem Description
Given n non-negative integers A[0], A[1], ..., A[n-1] , where each represents a point at coordinate (i, A[i]).

N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).

Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
Problem Constraints
0 <= N <= 10^5

1 <= A[i] <= 10^5

Input Format
Single Argument representing a 1-D array A.

Output Format
Return single Integer denoting the maximum area you can obtain.

TC =  O(N)
SC =  O(1)

 */

package TwoPointers;

import java.util.ArrayList;

public class ContainerMostWater {
    public int maxArea(ArrayList<Integer> A) {
        int i = 0;
        int j = A.size()-1;
        long ans = 0;
        while(i<A.size() && j>=0){
            int diff = j-i;
            long temp = (Math.min(A.get(i),A.get(j))) * (Math.abs(diff));
            ans = Math.max(temp,ans);
            if(A.get(i)<A.get(j)){
                i++;
            } else if(A.get(i)>A.get(j)){
                j--;
            }else{
                i++;
                j--;
            }
        }
        return (int)ans;
    }
}
