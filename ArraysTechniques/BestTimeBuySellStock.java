/* Best Time to Buy and Sell Stocks I
Problem Description
Say you have an array, A, for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
Return the maximum possible profit.

Problem Constraints
0 <= A.size() <= 700000
1 <= A[i] <= 10^7

Input Format
The first and the only argument is an array of integers, A.
Output Format
Return an integer, representing the maximum possible profit.

Example Input
Input 1:
A = [1, 2]
Input 2:
A = [1, 4, 5, 2, 4]

Example Output
Output 1:
1
Output 2:
4

TC = O(N)
SC = O(1)

 */
package ArraysTechniques;

import java.util.List;

public class BestTimeBuySellStock {
    public int maxProfit(final List<Integer> A) {
        int arrayLength = A.size();
        int profit =0 ;
        if(arrayLength==0 || arrayLength==1){
            return 0;
        }
        int ans = A.get(arrayLength-1);
        for(int i=arrayLength-2;i>=0;i--){
            if(ans<A.get(i)){
                ans=A.get(i);
            }
            profit = Math.max(profit,ans-A.get(i));
        }
        return profit;
    }
}
