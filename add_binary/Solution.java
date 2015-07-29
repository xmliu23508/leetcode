package add_binary;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int v = carry;
            if (i >= 0) {
                v += a.charAt(i) - '0';
            }
            if (j >= 0) {
                v += b.charAt(j) - '0';
            }
            carry = v / 2;
            sb.append(v % 2);
        }
        if (carry == 1) {
            sb.append(carry);
        }
        sb.reverse();
        if (sb.indexOf("1") == -1) {
            return "0";
        } else {
            return sb.substring(sb.indexOf("1"));
        }
    }
}
