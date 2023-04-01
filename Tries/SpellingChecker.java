/*Spelling Checker
Problem Description
Given an array of words A (dictionary) and another array B (which contain some words).

You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.

Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.

Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.

NOTE: Try to do this in O(n) time complexity.
Problem Constraints
1 <= |A| <= 1000
1 <= sum of all strings in A <= 50000
1 <= |B| <= 1000

Input Format
First argument is array of strings A.
First argument is array of strings B.

Output Format
Return the binary array of integers according to the given format.

TC=O(N)
SC= O(1)

 */

package Tries;

import java.util.ArrayList;

public class SpellingChecker {
    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
        TrieNode root = new TrieNode();
        ArrayList<Integer> resultList = new ArrayList<>();

        for(int a=0;a<B.size();a++){
            resultList.add(a);
        }

        for(int d=0;d<A.size();d++){
            insert(A.get(d),root);
        }

        for(int p=0;p<B.size();p++){
            if(search(B.get(p),root)==true){
                resultList.set(p,1);
            }else{
                resultList.set(p,0);
            }
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
            temp = temp.children[indexToInsert];
        }
        temp.isEnd = true;
    }

    //Search the element in the trie data structure
    boolean search(String searchWord,TrieNode root){
        TrieNode temp = root;
        int sizeOfWord = searchWord.length();
        for(int r=0;r<sizeOfWord;r++){
            char characterOfString= searchWord.charAt(r);
            int indexToInsert = characterOfString - 'a';
            if(temp.children[indexToInsert]==null){
                return false;
            }
            temp = temp.children[indexToInsert];
        }
        return temp.isEnd;
    }
}

//trie data structure defination
class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
    TrieNode(){
        isEnd = false;
        for(int d=0;d<26;d++){
            children[d] =null;
        }
    }
}
