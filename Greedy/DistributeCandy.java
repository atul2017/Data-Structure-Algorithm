/*Distribute Candy
Problem Description
N children are standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum number of candies you must give?

Problem Constraints
1 <= N <= 10^5
-109 <= A[i] <= 10^9
Input Format
The first and only argument is an integer array A representing the rating of children.
Output Format
Return an integer representing the minimum candies to be given.
Example Input
Input 1:
A = [1, 2]
Input 2:
A = [1, 5, 2, 1]
Example Output
Output 1:
3
Output 2:
7
TC=O(N)
SC=O(N)

 */

package Greedy;

import java.util.ArrayList;

public class DistributeCandy {
    public int candy(ArrayList<Integer> A) {

        //First every student will have one Candy
        ArrayList<Integer> candyList = new ArrayList<>();
        for(int p=0;p<A.size();p++){
            candyList.add(1);
        }

        //count of candies from left to right
        for(int d=1;d<A.size();d++){
            if(A.get(d)>A.get(d-1)){
                candyList.set(d,candyList.get(d-1)+1);
            }
        }

        //count of candies from right to left
        for(int a=A.size()-2;a>=0;a--){
            if(A.get(a)>A.get(a+1)){
                if(candyList.get(a)<=candyList.get(a+1)){
                    candyList.set(a,candyList.get(a+1)+1);
                }
            }
        }
        long ans = 0;
        for(int r=0;r<candyList.size();r++){
            ans += candyList.get(r);
        }
      return (int)ans;
    }
}
