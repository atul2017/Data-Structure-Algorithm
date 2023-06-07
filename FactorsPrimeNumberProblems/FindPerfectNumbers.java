/* Find Perfect Numbers
Problem Description
You are given an integer A. You have to tell whether it is a perfect number or not.
Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
A proper divisor of a natural number is the divisor that is strictly less than the number.

Problem Constraints
1 <= A <= 10^6

Input Format
First and only argument contains a single positive integer A.
Output Format
Return 1 if A is a perfect number and 0 otherwise.

Example Input
Input 1:
A = 4
Input 2:
A = 6

Example Output
Output 1:
0
Output 2:
1

TC = O(A)
SC = O(1)

 */

package FactorsPrimeNumberProblems;

public class FindPerfectNumbers {
    public int solve(int A) {
        int count = 1;

        if (A==1){
            return 0;
        }
        for(int i=2;i<=A/2;i++){
            if(A%i==0){
                count = count + i ;
            }
        }

        if (count==A){
            return 1;
        }
        else
            return 0;

    }
}
