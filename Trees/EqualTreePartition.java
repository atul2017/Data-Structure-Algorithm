/*Equal Tree Partition
Problem Description
Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.
Problem Constraints
1 <= size of tree <= 100000
0 <= value of node <= 10^9
Input Format
First and only argument is head of tree A.
Output Format
Return 1 if the tree can be partitioned into two trees of equal sum else return 0.

TC = O(N+N) O(N)
SC = O(H)
 */

package Trees;

public class EqualTreePartition {

    //This is global variable to store sum of all nodes in the tree and answer
    long sumOfNodes = 0;
    int ans = 0;
    public int solve(TreeNode A) {
        sumOfNodes =  sum(A);
        if(sumOfNodes%2==1){
            ans = 0;
        }else{
            partialSum(A);
        }
        return ans;
    }

    //This method traverse all subtrees and sum of all subtree nodes
    long partialSum(TreeNode root){
        if(root==null){
            return 0;
        }
        long leftSum = partialSum(root.left);
        long rightSum = partialSum(root.right);
        if(leftSum==sumOfNodes/2 ||  rightSum==sumOfNodes/2){
            ans = 1;
        }
        return leftSum+rightSum+root.val;
    }

    //Method to find out the sum of the entire tree
    long sum(TreeNode root){
        if(root==null){
            return 0;
        }
        return sum(root.left) + root.val + sum(root.right);
    }
}
