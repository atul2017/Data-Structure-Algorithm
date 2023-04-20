/*Stairs
Problem Description
You are climbing a staircase and it takes A steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Return the number of distinct ways modulo 1000000007

Problem Constraints
1 <= A <= 10^5
Input Format
The first and the only argument contains an integer A, the number of steps.
Output Format
Return an integer, representing the number of ways to reach the top.

TC=O(N)
SC=O(N)

*/

package DynamicProgramming;

public class Stairs {
    public int climbStairs(int A) {
        long[] fibArray = new long[A+1];
        for(int d=0;d<=A;d++){
            fibArray[d] = -1L;
        }
        long result = new Stairs().fib(A,fibArray) + new Stairs().fib(A-1,fibArray);
        result = result%1000000007;
        return (int) result;
    }

    long fib(int number,long[] fibArray){
        if(number<=1){
            return number;
        }
        if(fibArray[number]!=-1){
            return fibArray[number];
        }
        fibArray[number] = fib(number-1,fibArray)+fib(number-2,fibArray);
        return fibArray[number]%1000000007;
    }
}
