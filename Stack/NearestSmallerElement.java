/*Nearest Smaller Element
Problem Description
Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
More formally,
G[i] for an element A[i] = an element A[j] such that
j is maximum possible AND j < i AND A[j] < A[i]
Elements for which no smaller element exist, consider the next smaller element as -1.
Problem Constraints
1 <= |A| <= 100000
-10^9 <= A[i] <= 10^9
Input Format
The only argument given is integer array A.
Output Format
Return the integer array G such that G[i] contains the nearest smaller number than A[i]. If no such element occurs G[i] should be -1.

TC = O(N)
SC = O(N)
*/


package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> resultList = new ArrayList<>();

        for(int p=0;p<A.size();p++){
            resultList.add(0);
        }

        if(A.size()==0){
            return resultList;
        }
        if(A.size()==1){
            resultList.set(0,-1);
            return resultList;
        }

        for(int d=0;d<A.size();d++){
            while(!stack.isEmpty() && A.get(stack.peek()) >= A.get(d)){
                stack.pop();
            }
            if(stack.isEmpty()){
                resultList.set(d,resultList.get(d)-1);
            }else{
                resultList.set(d,A.get(stack.peek()));
            }
            stack.push(d);
        }
        return resultList;
    }
}
