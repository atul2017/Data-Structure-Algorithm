package Tries;

import java.util.ArrayList;

public class SubArrayWithMaxXOR {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        //Prefix XOR list
        ArrayList<Integer> xorList = new ArrayList<>();
        xorList.add(A.get(0));
        int maxOfXOR = A.get(0);
        int indexOfMOR = 0;
        for(int d=1;d<A.size();d++){
            int xor = xorList.get(d-1) ^ A.get(d);
            xorList.add(xor);
            if(xor>maxOfXOR){
                maxOfXOR = xor;
                indexOfMOR=d;
            }
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        resultList.add(0,indexOfMOR+1);
        resultList.add(1,indexOfMOR+1);

        TrieNode root = new TrieNode();
        for(int d=0;d<xorList.size();d++){
            TrieNode temp = root;
            for(int p=31;p>=0;p--){
                int b = (xorList.get(d)>>p) & 1;
                if(b==0){
                    if(temp.left==null){
                        temp.left = new TrieNode();
                    }
                    temp = temp.left;
                }else{
                    if(temp.right==null){
                        temp.right = new TrieNode();
                    }
                    temp = temp.right;
                }
            }
            temp.data = xorList.get(d);
        }

        for(int r=0;r<xorList.size();r++){
            TrieNode current = root;
            int sum = 0;
            for(int a=31;a>=0;a--){
                int b =  (xorList.get(r)>>a) & 1;
                if(b==0){
                    if(current.right!=null){
                        sum += (1<<a);
                        current = current.right;
                    }else{
                        current = current.left;
                    }
                }else{
                    if(current.left!=null){
                        sum += (1<<a);
                        current = current.left;
                    }else{
                        current = current.right;
                    }
                }
            }
            maxOfXOR = Math.max(sum,maxOfXOR);
        }
        return resultList;
    }
}

class TrieNode{
    TrieNode left ; //left points to zero
    TrieNode right ; //right points to zero
    int data;
    TrieNode(){
        left = null;
        right = null;
        data =0;
    }
}
