package count_and_say;

public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int l = 0;
            while (l < s.length()) {
                int j = l + 1;
                for (; j < s.length() && s.charAt(j) == s.charAt(l); j++)
                    ;
                sb.append(j - l).append(s.charAt(l));
                l = j;
            }
            s = sb.toString();
        }
        return s;
    }
}
