package implement_strstr;

public class Solution {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            for (; j < needle.length()
                    && haystack.charAt(i + j) == needle.charAt(j); j++)
                ;
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}