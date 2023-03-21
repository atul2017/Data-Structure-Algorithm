/* First non-repeating character
Problem Description
Given a string A denoting a stream of lowercase alphabets, you have to make a new string B.
B is formed such that we have to find the first non-repeating character each time a character is inserted to the stream and append it at the end to B. If no non-repeating character is found, append '#' at the end of B.

Problem Constraints
1 <= |A| <= 100000
Input Format
The only argument given is string A.
Output Format
Return a string B after processing the stream of lowercase alphabets A.

SC=O(N)
TC=O(N)
 */


package Queues;

import java.util.HashMap;
import java.util.LinkedList;

public class FirstNonRepeatingCharacter {
    public String solve(String A) {

        LinkedList<Character> queue = new LinkedList<>();

        HashMap<Character,Integer> map = new HashMap<>();

        StringBuilder result = new StringBuilder("");

        for(int d=0;d<A.length();d++){
            boolean ifFound = false;
            char ch = A.charAt(d);
            queue.add(ch);
            if(map.containsKey(ch)){
                int mapVal = map.get(ch);
                mapVal += 1;
                map.put(ch,mapVal);
            }else{
                map.put(ch,1);
            }

            while(!queue.isEmpty()){

                //get the element from the front
                char charac = queue.peek();

                //check the frequency of the character in the map
                if(map.containsKey(charac)){
                    int mapVal = map.get(charac);
                    if(mapVal>1){
                        queue.remove();
                    }else{
                        result.append(charac);
                        ifFound = true;
                        break;
                    }
                }else{
                    result.append(charac);
                    map.put(charac,1);
                    ifFound = true;
                    break;
                }
            }
            if(!ifFound){
                result.append('#');
            }
        }
        return result.toString();
    }
}
