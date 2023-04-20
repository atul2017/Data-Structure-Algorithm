/*Fibonacci Number
Problem Description
Given a positive integer A, write a program to find the Ath Fibonacci number.
In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series are 0 and 1. i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.
NOTE: 0th term is 0. 1th term is 1 and so on.
Problem Constraints
0 <= A <= 44
Input Format
First and only argument is an integer A.
Output Format
Return an integer denoting the Ath Fibonacci number.

TC = O(N)
SC = O(N)
 */


package DynamicProgramming;

import java.util.Scanner;

public class FibonacciNumber {
    static int number = 0;
    static long[] fibArray = null;
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scanner = new Scanner(System.in);
        number = Integer.valueOf(scanner.next());

        fibArray = new long[number+1];
        for(int d=0;d<=number;d++){
            fibArray[d] = -1L;
        }
        long result = new FibonacciNumber().fib(number);
        System.out.println(result);
    }
    long fib(int number){
        if(number<=1){
            return number;
        }
        if(fibArray[number]!=-1){
            return fibArray[number];
        }
        fibArray[number] = fib(number-1)+fib(number-2);
        return fibArray[number];
    }
}
