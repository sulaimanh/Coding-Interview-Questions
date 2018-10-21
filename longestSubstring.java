import java.util.*;

// Sulaiman Hamouda

/*
	Given a string, find the length of the longest substring without repeating characters.

	Example 1:

	Input: "abcabcbb"
	Output: 3 
	Explanation: The answer is "abc", with the length of 3. 
	Example 2:

	Input: "bbbbb"
	Output: 1
	Explanation: The answer is "b", with the length of 1.
	Example 3:

	Input: "pwwkew"
	Output: 3
	Explanation: The answer is "wke", with the length of 3. 
	             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/


public class longestSubstring{
	public static void main(String [] args){
		int length = lengthOfLongestSubstring("abcabcbb"));
		System.out.println("Length of the longest substring is " + length);
	}

	public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 1)
            return 1;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int beg = 0;
        int length = 0;
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i)))
                // - Here, we will see where we should start the new substring
                if(map.get(s.charAt(i))+1 > beg)
                    beg = map.get(s.charAt(i)) + 1;
            
            // - If the new length is greater than the previous length, then we will update it
            if(length < (i+1) - beg)
                length = (i+1) - beg;
            // - We will insert the character and update the index
            map.put(s.charAt(i), i);
        }
        
        return length;
    }  
}