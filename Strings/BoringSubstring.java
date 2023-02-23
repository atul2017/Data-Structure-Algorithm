/*Boring substring
Problem Description
You are given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.

A boring substring has the following properties:

Its length is 2.
Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.

Problem Constraints
1 <= |A| <= 10^5

Input Format
The only argument given is a string A.

Output Format
Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.

TC = O(N)
SC = O(1)

 */

package Strings;

import java.util.ArrayList;
import java.util.Collections;

public class BoringSubstring {

    public int solve(String A) {

        ArrayList<Character> oddCharacter = new ArrayList<>();
        ArrayList<Character> evenCharacter = new ArrayList<>();

        //Divide characters in two pools
        for(int d=0;d<A.length();d++){
            if(A.charAt(d)%2==0){
                evenCharacter.add(A.charAt(d));
            }else{
                oddCharacter.add(A.charAt(d));
            }
        }
        //sort the character arraylist
        Collections.sort(oddCharacter);
        Collections.sort(evenCharacter);

        //Find out the smallest and largest character from arrayList
        char sl = oddCharacter.get(0);
        char ll = oddCharacter.get(oddCharacter.size()-1);

        //Find out the smallest and largest character from arrayList
        char sr = evenCharacter.get(0);
        char lr = evenCharacter.get(evenCharacter.size()-1);

        //compare the largest and smallest from both pools to check if they are consecutive
        if(Math.abs(sl-sr)!=1){
            return 1;
        }else if(Math.abs(sl-lr)!=1){
            return 1;
        }else if(Math.abs(ll-sr)!=1){
            return 1;
        }else if(Math.abs(ll-lr)!=1){
            return 1;
        }
        return 0;
    }


}
