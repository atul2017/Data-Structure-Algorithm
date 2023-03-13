/*Largest Rectangle in Histogram
Problem Description
Given an array of integers A. A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
Find the area of the largest rectangle formed by the histogram.
Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 1000000000
Input Format
The only argument given is the integer array A.
Output Format
Return the area of the largest rectangle in the histogram.
T(C) = O(N)
S(C) = O(N)
 */


package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(ArrayList<Integer> A) {

        ArrayList<Integer> nearestSmallerLeft = new ArrayList<>();
        Stack<Integer> stackLeft = new Stack<>();

        ArrayList<Integer> nearestSmallerRigth = new ArrayList<>();
        Stack<Integer> stackRight = new Stack<>();

        if(A.size()==0){
            return 0;
        }
        if(A.size()==1){
            return A.get(0);
        }

        for(int r=0;r<A.size();r++){
            nearestSmallerLeft.add(0);
            nearestSmallerRigth.add(0);
        }

        //Nearest Smaller on left side
        for(int d=0;d<A.size();d++){
            while(!stackLeft.isEmpty() && A.get(stackLeft.peek()) >= A.get(d)){
                stackLeft.pop();
            }
            if(stackLeft.isEmpty()){
                nearestSmallerLeft.set(d,-1);
            }else{
                nearestSmallerLeft.set(d,stackLeft.peek());
            }
            stackLeft.push(d);
        }


        //Nearest Smaller on right side
        for(int p=A.size()-1;p>=0;p--){
            while(!stackRight.isEmpty() && A.get(stackRight.peek()) >= A.get(p)){
                stackRight.pop();
            }
            if(stackRight.isEmpty()){
                nearestSmallerRigth.set(p,A.size());
            }else{
                nearestSmallerRigth.set(p,stackRight.peek());
            }
            stackRight.push(p);
        }

        int ans = Integer.MIN_VALUE;
        for(int a=0;a<A.size();a++){
            int tempVar = A.get(a) * (nearestSmallerRigth.get(a)-nearestSmallerLeft.get(a)-1);
            ans = Math.max(ans,tempVar);
        }
        return ans;
    }
}
