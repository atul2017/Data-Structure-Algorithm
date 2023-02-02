/*Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.*/

/*Problem Constraints
-1010 <= A[i], B[i] <= 1010*/

/* T(C) - o(N)
   S(C) - o(N)
 */
package Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSortProblem {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {

        //This will store the sorted values from both the arraylist
        ArrayList<Integer> resultArray = new ArrayList<>();

        //These are two pointer to be used
        int i = 0;
        int j = 0;

        //Size of two arrays
        int n = A.size();
        int m = B.size();

        for(int d=0;d<=n+m-1;d++){
            if(i==n){
                resultArray.add(d,B.get(j));
                j += 1;
            }else if(j==m){
                resultArray.add(d,A.get(i));
                i += 1;
            }else if(A.get(i)<=B.get(j)){
                resultArray.add(d,A.get(i));
                i += 1;
            }else{
                resultArray.add(d,B.get(j));
                j += 1;
            }
        }
        return resultArray;
    }
}
