/*House color
In a small town, there are N shops lined up on a street. Each shop is painted with a certain color. You are given an array A of length N, where A[i] represents the color of the ith shop.
Return the maximum distance between two shops with different colors. the distance between the ith and jth shops is abs(i-j) where abs(x) is the absolute value of x.
If there are no two shops with different colours return -1.

Problem constraint -
1<=A.length<=10^6
1<=A[i]<=10^9

Input format-
There is only one argument, array A, representing the shops's colors
Output format -
Return an integer denoting maximum distance between two shops with different colors

TC= O(N)
SC = O(1)

 */

package TwoPointers;

import java.util.ArrayList;

public class HouseColor {
    public int solve(ArrayList<Integer> A) {
        if(A.size()==1){
            return -1;
        }
        int j = A.size()-1;
        int i =0;
        while(i<=j){
            if(A.get(i)!=A.get(j)){
                break;
            }
            i++;
        }
        while(j>=0){
            if(A.get(0)!=A.get(j)){
                break;
            }
            j--;
        }
        return Math.max(j,j-i);
    }
}
