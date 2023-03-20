/* Vertical Order traversal
Problem Description
Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
Problem Constraints
0 <= number of nodes <= 10^5
Input Format
First and only argument is a pointer to the root node of binary tree, A.
Output Format
Return a 2D array denoting the vertical order traversal of tree as shown.

SC =O(N)
TC =O(N)
*/

package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;

public class VerticalOrderTraversing {
    class Pair{
        TreeNode treeNode;
        int data;
        Pair(TreeNode t, int data){
            treeNode = t;
            this.data = data;
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

        if(A==null){
            return null;
        }
        //data structure for queue and store the pairs
        LinkedList<Pair> queue = new LinkedList<>();

        //data structure for node and it's level
        TreeMap<Integer,ArrayList> resultMap = new TreeMap<>();

        //data structure to store the results
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

        queue.add(new Pair(A,0));
        TreeNode last = A;
        while(!queue.isEmpty()){
            ArrayList<Integer> list = null;
            Pair pairData = queue.remove();
            TreeNode node = pairData.treeNode;
            int x = pairData.data;
            if(node.left!=null){
                queue.add(new Pair(node.left,x-1));
            }
            if(node.right!=null){
                queue.add(new Pair(node.right,x+1));
            }
            if(node==last){
                Pair pData = queue.peekLast();
                TreeNode tNode = null;
                if(pData!=null){
                    tNode =  pData.treeNode;
                }
                if(tNode!=null){
                    last = tNode;
                }
            }
            //this result map is to store the node values on each vertical line
            if(resultMap.containsKey(pairData.data)){
                //System.out.println("Contains->True");
                list = resultMap.get(pairData.data);
                list.add(node.val);
                resultMap.put(pairData.data,list);
            }else{
                //System.out.println("Contains->false");
                list = new ArrayList<>();
                list.add(node.val);
                resultMap.put(pairData.data,list);
            }
        }
        //iterate through the result map and store the values in the result list
        Set<Integer> set1 =  resultMap.keySet();
        for(Integer key : set1){
            resultList.add(resultMap.get(key));
        }
        return resultList;
    }
}

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
