package longest_substring_without_repeat;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c)+1);
            }
            map.put(c, i);
            max = Math.max(max,i-left);
        }
        return max;
        
    }
}