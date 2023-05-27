/*IsPrime
Problem Description
Given a number A. Return 1 if A is prime and return 0 if not.

Note :
The value of A can cross the range of Integer.
Problem Constraints
1 <= A <= 10^12

Input Format
The first argument is a single integer A.
Output Format
Return 1 if A is prime else return 0.
Example Input
Input 1:
A = 5
Input 2:
A = 10

Example Output
Output 1:
1
Output 2:
0

TC = O(sqrt(A))
SC = O(1)
 */
package FactorsPrimeNumberProblems;

public class IsPrime {
    public int solve(long A) {
        int j =0;
        if(A==1){
            return 0;
        }
        for(long i=2;i*i<=A ;i++){
            if(A%i==0){
                j=0;
                return j;
            }
        }
        return 1;
    }
}
