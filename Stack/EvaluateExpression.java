/*Evaluate Expression
Problem Description
An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each string may be an integer or an operator.
Problem Constraints
1 <= N <= 10^5
Input Format
The only argument given is string array A.
Output Format
Return the value of arithmetic expression formed using reverse Polish Notation.

TC = O(N)
SC= O(N)

 */
package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {
    public int evalRPN(ArrayList<String> A) {

        //Stack to maintain the operator and operand
        Stack<String> stack = new Stack<>();

        for(int d=0;d<A.size();d++){
            if(!A.get(d).equals("*") && !A.get(d).equals("/") && !A.get(d).equals("+") && !A.get(d).equals("-")){
                stack.push(A.get(d));
            }else{
                int x = Integer.valueOf(stack.pop());
                int y = Integer.valueOf(stack.pop());
                String operator = A.get(d);
                int temp = 0;
                if(operator.equals("+")){
                    temp = y+x;
                }else if(operator.equals("-")){
                    temp = y-x;
                }else if(operator.equals("/")){
                    temp = y/x;
                }else{
                    temp = y*x;
                }
                stack.push(String.valueOf(temp));
            }
        }
        return Integer.valueOf(stack.peek());
    }
}
