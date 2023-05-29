/* Count Factors - 2
Problem Description
Given an integer A, you need to find the count of it's factors.
Factor of a number is the number which divides it perfectly leaving no remainder.
Example : 1, 2, 3, 6 are factors of 6

Problem Constraints
1 <= A <= 10^9

Input Format
First and only argument is an integer A.
Output Format
Return the count of factors of A.
Example Input
Input 1:
5
Input 2:
10

TC = O(A/2) = O(A)
SC = O(1)
*/

package FactorsPrimeNumberProblems;
public class CountFactors {
    public int solve(int A) {
        int count = 0;
        for(int i=2;i<=A/2;i++){
            if(A%i==0)
                count = count +1 ;
        }
        return count+2;
    }
}
