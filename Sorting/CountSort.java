/*Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.

Problem Constraints
1 <= |A| <= 10^5
1 <= A[i] <= 10^5

Input Format
The first argument is an integer array A.
Output Format
Return an integer array that is the sorted array A.
*/

package Sorting;

import java.util.ArrayList;

public class CountSort {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        //This ArrayList stores the frequency
        ArrayList<Integer> frequencyList = new ArrayList<>();

        //First initialize arraylist with zeor
        for(int k=0;k<=100000;k++){
            frequencyList.add(k,0);
        }

        //store frequency of array elements
        for(int d=0;d<A.size();d++){
            frequencyList.set( A.get(d), frequencyList.get(A.get(d)) + 1);
        }

        //generate the ArrayList based on the frequency array
        ArrayList<Integer> finalResult = new ArrayList<>();
        for(int p=0;p<frequencyList.size();p++){
            if(frequencyList.get(p)!=0){
                for(int r=0;r<frequencyList.get(p);r++){
                    finalResult.add(p);
                }
            }
        }
        return finalResult;
    }
}
