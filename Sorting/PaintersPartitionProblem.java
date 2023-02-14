/* Painter's Partition Problem
Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.

Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.

Return the ans % 10000003.

Problem Constraints
1 <= A <= 1000
1 <= B <= 10^6
1 <= N <= 10^5
1 <= C[i] <= 10^6

Input Format
The first argument given is the integer A.
The second argument given is the integer B.
The third argument given is the integer array C.


Output Format
Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.

TC = O[Nlog(Range)] = O(Nlog(sum of blocks*B)) The binary search is being performed not on the index but the paint time
SC = O(1)

 */


package Sorting;

public class PaintersPartitionProblem {
    public int paint(int A, int B, ArrayList<Integer> C) {
        //A is number of painters
        //B is units of time

        //Define the search space
        long sumOfBlocks =0;
        for(int d =0;d<C.size();d++){
            sumOfBlocks += C.get(d);
        }
        long maxBoardLength = Collections.max(C);
        long start = maxBoardLength*B;
        long end = sumOfBlocks*B;
        long mid = 0;

        while(start<=end){
            mid = (start+end)/2;
            long paintersCount = numberOfPainters(C,mid,B);
            long paintersCount1 = numberOfPainters(C,mid-1,B);
            //check if mid is the answer
            if( paintersCount<=A && paintersCount1>A){
                return (int)(mid%10000003);
            }
            //decide when to go right or left
            if(paintersCount > A){
                start = mid+1;
            }else{
                end = mid -1;
            }
        }
        return (int)(mid%10000003);
    }

    public int numberOfPainters(ArrayList<Integer> C,long mid,long B){
        //define search space
        long start = 0;
        long end = C.size();
        long time = mid;
        int count = 1;

        for(int p=0;p<end;p++){
            if((C.get(p)*B)>mid){
                return -1;
            }else if((C.get(p)*B)<=time){
                time -= C.get(p)*B;
            }else{
                count++;
                time = mid-C.get(p)*B;
            }
        }
        return count;
    }
}
