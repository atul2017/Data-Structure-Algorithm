/*Shortest Unique Prefix
Problem Description
Given a list of N words, find the shortest unique prefix to represent each word in the list.
NOTE: Assume that no word is the prefix of another. In other words, the representation is always possible
Problem Constraints
1 <= Sum of length of all words <= 10^6
Input Format
First and only argument is a string array of size N.
Output Format
Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.

TC=O(length of all N words)
SC=O(length of all N words)

*/


package Tries;

import java.util.ArrayList;

public class ShortestUniquePrefix {
    public ArrayList<String> prefix(ArrayList<String> A){

        //Insert the element in the trie
        TrieNode root = new TrieNode();
        for(int d=0;d<A.size();d++){
            insert(A.get(d),root);
        }

        //Prepare the arrayList of Strings
        ArrayList<String> resultList = new ArrayList<>();
        for(int p=0;p<A.size();p++){
            resultList.add("");
        }

        //Find the element and prepare the answer
        for(int r=0;r<A.size();r++){
            resultList.set(r,search(A.get(r),root).trim());
        }

        return resultList;
    }

    //Create the Trie data structure and insert the element
    void insert(String key,TrieNode root){
        int height;
        int lengthofWord = key.length();
        int indexToInsert;
        TrieNode temp = root;
        for(height=0;height<lengthofWord;height++){
            indexToInsert = key.charAt(height) - 'a';
            if(temp.children[indexToInsert]==null){
                temp.children[indexToInsert] = new TrieNode();
            }
            temp.count[indexToInsert] +=1;
            temp = temp.children[indexToInsert];
        }
        temp.isEndOfWord = true;
    }


    //Search the element in the trie data structure
    String search(String searchWord,TrieNode root){
        TrieNode temp = root;
        int sizeOfWord = searchWord.length();
        String ans=" ";
        for(int r=0;r<sizeOfWord;r++){
            char characterOfString= searchWord.charAt(r);
            int indexToInsert = characterOfString - 'a';
            if(temp.count[indexToInsert]==1){
                ans += searchWord.charAt(r);
                return ans;
            }else{
                ans += searchWord.charAt(r);
                temp = temp.children[indexToInsert];
            }
        }
        return ans;
    }
}

//trie data structure defination
class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
    int[] count = new int[26];
    TrieNode(){
        isEndOfWord = false;
        for(int d=0;d<26;d++){
            children[d] =null;
            count[d] = 0;
        }
    }
}



