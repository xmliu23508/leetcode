package palindrome_partition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (isPalindrome(s, 0, i)) {
                for (List<String> l : partition(s.substring(i + 1))) {
                    l.add(0, s.substring(0, i + 1));
                    result.add(l);
                }
            }
        }
        if (isPalindrome(s, 0, s.length() - 1)) {
            result.add(new ArrayList<String>(Arrays.asList(s)));
        }
        return result;
    }

    boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}