/*Balanced Paranthesis
Problem Description
Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
Refer to the examples for more clarity.

Problem Constraints
1 <= |A| <= 100
Input Format
The first and the only argument of input contains the string A having the parenthesis sequence.
Output Format
Return 0 if the parenthesis sequence is not balanced.
Return 1 if the parenthesis sequence is balanced.

TC = O(N)
SC = O(N)
 */

package Stack;

import java.util.Stack;

public class BalancedParanthesis{
    public int solve(String A){
        Stack<String> stack = new Stack<>();

        //handle the edge case
        if(String.valueOf(A.charAt(0)).equals("}") || String.valueOf(A.charAt(0)).equals("]") || String.valueOf(A.charAt(0)).equals(")")){
            return 0;
        }

        //populate each paranthesis from the String A
        for(int d=0;d<A.length();d++){
            if(String.valueOf(A.charAt(d)).equals("{") || String.valueOf(A.charAt(d)).equals("(") || String.valueOf(A.charAt(d)).equals("[")){
                stack.push(String.valueOf(A.charAt(d)));
            }else{
                String popStr = stack.peek();
                if(String.valueOf(A.charAt(d)).equals("}")){
                    if(popStr.equals("{")){
                        stack.pop();
                    }
                }else if(String.valueOf(A.charAt(d)).equals(")")){
                    if(popStr.equals("(")){
                        stack.pop();
                    }
                }else if(String.valueOf(A.charAt(d)).equals("]")){
                    if(popStr.equals("[")){
                        stack.pop();
                    }
                }else{
                    return 0;
                }
            }
        }
        //All the combinations are found if the stack is empty
        if(stack.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }
}
