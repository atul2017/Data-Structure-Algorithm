/* Count of primes
Problem Description
You will be given an integer n. You need to return the count of prime numbers less than or equal to n.
Problem Constraints
0 <= n <= 10^3
Input Format
Single input parameter n in function.
Output Format
Return the count of prime numbers less than or equal to n.

Example Input
Input 1:
19
Input 2:
1

Example Output
Output 1:
8
Output 2:
0

TC = O(A^2)
SC = O(1)

 */

package FactorsPrimeNumberProblems;

public class CountOfPrimeNumbers {
    public int solve(int A) {
        int primeCount =0;
        for(int i=2;i<=A;i++){
            boolean isPrime = true;
            for(int j=2; j<i;j++){
                if(i%j==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime==true){
                primeCount++;
            }
        }
        return primeCount;
    }
}
