/*Fractional Knapsack
Problem Description
Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
Also given an integer C which represents knapsack capacity.
Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).
NOTE:
You can break an item for maximizing the total value of the knapsack

Problem Constraints
1 <= N <= 10^5
1 <= A[i], B[i] <= 10^3
1 <= C <= 10^3
Input Format
First argument is an integer array A of size N denoting the values on N items.
Second argument is an integer array B of size N denoting the weights on N items.
Third argument is an integer C denoting the knapsack capacity.
Output Format
Return a single integer denoting the maximum total value of A such that sum of the weights of this subset is smaller than or equal to C.

TC= O(NlogN)
SC = O(1)
 */

package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FractionalKnapsack {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        ArrayList<Item> resultList = new ArrayList<>();

        for(int d=0;d<A.size();d++){
            double div = (A.get(d)*100.0)/B.get(d);
            resultList.add(new Item(A.get(d)*100, B.get(d), div));
        }

        Collections.sort(resultList);

        double ans =0;
        int weight1 =0;
        int temp = 0;

        for(int p=A.size()-1;p>=0;p--){
            weight1 = weight1 + resultList.get(p).weight;
            if(weight1>C){
                ans = ans + ((C-temp)*resultList.get(p).ratio);
                return (int)Math.floor(ans);
            }else{
                ans = ans + resultList.get(p).val;
                temp = temp + resultList.get(p).weight;
            }
        }
        return  (int)Math.floor(ans);
    }
}
class Item implements Comparable<Item>{
    int val;
    int weight;
    double ratio;

    Item(int val, int weight, double ratio){
        this.val = val;
        this.weight = weight;
        this.ratio = ratio;
    }

    public int compareTo(Item o){
        if(this.ratio > o.ratio){
            return 1;
        }else if(this.ratio < o.ratio){
            return -1;
        }else{
            return 0;
        }
    }

    Item(){}
}

