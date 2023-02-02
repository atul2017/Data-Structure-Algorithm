/*Find the Bth smallest element in given array A .

NOTE: Users should try to solve it in less than equal to B swaps.*/

/*Problem Constraints
1 <= |A| <= 100000

1 <= B <= min(|A|, 500)

1 <= A[i] <= 109 */

/* T(C) - o(N^2)
   S(C) - o(1)
 */

package Sorting;

public class SelectionSortProblem {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {
        for(int i=0;i<B;i++){
            int min = Integer.MAX_VALUE;
            int idx =0;
            for(int j=i;j<A.length;j++){
                if(A[j] < min){
                    min = A[j];
                    idx = j;
                }
            }
            int tmp = A[i];
            A[i] = A[idx];
            A[idx] = tmp;
        }
        return A[B-1];
    }
}
