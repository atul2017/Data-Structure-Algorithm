/* Special Subsequences "AG"
Problem Description
You have given a string A having Uppercase English letters.
You have to find how many times subsequence "AG" is there in the given string.
NOTE: Return the answer modulo 10^9 + 7 as the answer can be very large.

Problem Constraints
1 <= length(A) <= 105
Input Format
First and only argument is a string A.
Output Format
Return an integer denoting the answer.

Example Input
Input 1:
A = "ABCGAG"
Input 2:
A = "GAB"

Example Output
Output 1:
3
Output 2:
0

TC = O(N)
SC = O(1)

*/

package ArraysTechniques;

public class SpecialSubsequences {
    public int solve(String A) {
        int ans = 0;
        int c = 0;
        int mod =1000*1000*1000+7;
        char[] chararray = A.toCharArray();
        for(int j=chararray.length-1;j>=0;j--){
            if(chararray[j]=='G'){
                c=c+1;
            }
            else if(chararray[j]=='A'){
                ans = ans + c;
                ans = ans%mod;
            }
        }
        return ans;
    }
}
