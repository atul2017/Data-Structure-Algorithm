/*Ways to form Max Heap
Problem Description
Max Heap is a special kind of complete binary tree in which, for every node, the value present in that node is greater than the value present in its children nodes.
Find the number of distinct Max Heap that can be made from A distinct integers.
In short, you have to ensure the following properties for the max heap :
Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.)
Every node is greater than all its children.
NOTE: If you want to know more about Heaps, please visit this link. Return your answer modulo 109 + 7.

Problem Constraints
1 <= A <= 100
Input Format
The first and only argument is an integer A.
Output Format
Return an integer denoting the number of distinct Max Heap.

TC=
SC=
 */

package Heap;

public class WaysToFormMaxHeap {
    long[][] nck = new long[105][105];

    int[] list = new int[105];

    int moduleNumber = 1000000007;

    public int solve(int A) {
        for (int i = 0; i <= A; i++){
            list[i] = -1;
        }
        for (int i = 0; i <= A; i++){
            for (int j = 0; j <= A; j++)
            {
                nck[i][j] = -1;
            }
        }
        return (int)calculateMaxHeap(A,list);
    }

    long calculateMaxHeap(int A, int[] list){
        if(A<=1){
            return 1;
        }
        if(list[A]!=-1){
            return list[A];
        }
        int leftNodes = numberOfNodesOnLeft(A);
        long waysToChooseL = choose(A-1,leftNodes);
        long maxHeapsUsingL = calculateMaxHeap(leftNodes,list);
        long maxHeapsUsingR = calculateMaxHeap(A-1-leftNodes,list);
        long ans = (long)(((waysToChooseL * maxHeapsUsingL)%moduleNumber)*maxHeapsUsingR)%moduleNumber;
        list[A] = (int)ans;
        return ans;
    }

    int numberOfNodesOnLeft(int A){
        int height = (int) (Math.log(A) / Math.log(2));
        int x = ((1<<(height-1))-1);
        int y = Math.min( (1<<(height-1)), (A-((1<<height)-1)) );
        return x+y;
    }

    long choose(int A, int B){
        if(B>A){return 0;}
        if(A<=1){return 1;}
        if(B==0){return 1;}
        if(B==1){return A;}

        if(nck[A][B]!=-1){
            return nck[A][B];
        }
        long result = (choose(A-1,B-1) + choose(A-1,B))%moduleNumber;
        nck[A][B]=result;
        return result;
    }
}
