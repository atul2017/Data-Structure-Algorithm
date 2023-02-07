/*Maximum Unsorted Subarray
Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.

Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 1000000

Input format-
First and only argument is an array of non-negative integers of size N.

Output Format -
Return an array of length two where the first element denotes the starting index(0-based) and the second element denotes the ending index(0-based) of the sub-array. If the array is already sorted, return an array containing only one element i.e. -1.

TC - O(N)
SC - O(N)
*/

package Sorting;

public class MaxUnsortedSubarray {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {

        int startIndex = 0;
        int endIndex =0;

        //Find the first element from right to left where left element is greater then right element
        for(int d=1;d<A.size();d++){
            int leftElement = A.get(d-1);
            int rightElement = A.get(d);
            if(leftElement>rightElement){
                startIndex = d-1;
                break;
            }
        }

        //Find the first element from left to right where right element is smaller then left element
        for(int p=A.size()-1;p>0;p--){
            int rightElement = A.get(p);
            int leftElement = A.get(p-1);
            if(leftElement>rightElement){
                endIndex = p;
                break;
            }
        }


        //Generte the ArrayList of indexes found in above logic
        ArrayList<Integer> tempList = new ArrayList<>();
        for(int r=startIndex;r<=endIndex;r++){
            tempList.add(A.get(r));
        }

        //Find min and max of the Arraylist
        int min =Collections.min(tempList);
        int max =Collections.max(tempList);

        //Find the firt element in original element from right to left which is grater then min and store that index
        for(int a=0;a<startIndex;a++){
            if(A.get(a)>min){
                startIndex = a;
                break;
            }
        }

        //Find the firt element in original element from left to right which is smaller then max and store that index
        for(int b=A.size()-1;b>=endIndex+1;b--){
            if(A.get(b)<max){
                endIndex = b;
                break;
            }
        }

        ArrayList<Integer> resultList = new ArrayList<>();

        if(startIndex==0 && endIndex==0){
            resultList.add(-1);
            return resultList;
        }

        resultList.add(startIndex);
        resultList.add(endIndex);

        return resultList;

    }

}
