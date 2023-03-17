/* MAX and MIN
Problem Description
Given an array of integers A.
value of a array = max(array) - min(array).
Calculate and return the sum of values of all possible subarrays of A modulo 109+7.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 1000000
Input Format
The first and only argument given is the integer array A.
Output Format
Return the sum of values of all possible subarrays of A modulo 109+7.
TC = O(N)
SC = O(N)

 */


package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class MaxAndMin {

    public int solve(ArrayList<Integer> A) {

        ArrayList<Integer> nearestSmallerLeft = new ArrayList<>();
        Stack<Integer> stackSmallerLeft = new Stack<>();

        ArrayList<Integer> nearestSmallerRigth = new ArrayList<>();
        Stack<Integer> stackSmallerRight = new Stack<>();

        ArrayList<Integer> nearestGreatestLeft = new ArrayList<>();
        Stack<Integer> stackGreatestLeft = new Stack<>();

        ArrayList<Integer> nearestGreatestRigth = new ArrayList<>();
        Stack<Integer> stackGreatestRight = new Stack<>();

        if(A.size()==0){
            return 0;
        }
        if(A.size()==1){
            return A.get(0);
        }

        for(int r=0;r<A.size();r++){
            nearestSmallerLeft.add(0);
            nearestSmallerRigth.add(0);
            nearestGreatestLeft.add(0);
            nearestGreatestRigth.add(0);
        }

        //Nearest Smaller on left side
        for(int d=0;d<A.size();d++){
            while(!stackSmallerLeft.isEmpty() && A.get(stackSmallerLeft.peek()) >= A.get(d)){
                stackSmallerLeft.pop();
            }
            if(stackSmallerLeft.isEmpty()){
                nearestSmallerLeft.set(d,-1);
            }else{
                nearestSmallerLeft.set(d,stackSmallerLeft.peek());
            }
            stackSmallerLeft.push(d);
        }


        //Nearest Smaller on right Side
        for(int p=A.size()-1;p>=0;p--){
            while(!stackSmallerRight.isEmpty() && A.get(stackSmallerRight.peek()) >= A.get(p)){
                stackSmallerRight.pop();
            }
            if(stackSmallerRight.isEmpty()){
                nearestSmallerRigth.set(p,A.size());
            }else{
                nearestSmallerRigth.set(p,stackSmallerRight.peek());
            }
            stackSmallerRight.push(p);
        }

        //Nearest Greater on left side
        for(int d=0;d<A.size();d++){
            while(!stackGreatestLeft.isEmpty() && A.get(stackGreatestLeft.peek()) <= A.get(d)){
                stackGreatestLeft.pop();
            }
            if(stackGreatestLeft.isEmpty()){
                nearestGreatestLeft.set(d,-1);
            }else{
                nearestGreatestLeft.set(d,stackGreatestLeft.peek());
            }
            stackGreatestLeft.push(d);
        }

        //Nearest Greatest on right Side
        for(int p=A.size()-1;p>=0;p--){
            while(!stackGreatestRight.isEmpty() && A.get(stackGreatestRight.peek()) <= A.get(p)){
                stackGreatestRight.pop();
            }
            if(stackGreatestRight.isEmpty()){
                nearestGreatestRigth.set(p,A.size());
            }else{
                nearestGreatestRigth.set(p,stackGreatestRight.peek());
            }
            stackGreatestRight.push(p);
        }
        long ans = 0;
        int mod = 1000000007;
        long maxC = 0;
        long minC =0;
        for(int a=0;a<A.size();a++){
            maxC = ((a-nearestGreatestLeft.get(a)) * 1L * (nearestGreatestRigth.get(a)-a));
            minC = ((a-nearestSmallerLeft.get(a)) * 1L * (nearestSmallerRigth.get(a)-a));
            long tempResult = A.get(a) % mod * (maxC-minC) % mod;
            ans = ans + tempResult;
            ans %=mod;
        }
        if(ans<0){
            ans+=mod;
        }
        return (int)ans;
    }
}
