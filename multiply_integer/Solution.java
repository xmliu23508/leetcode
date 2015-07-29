package multiply_integer;

public class Solution {
    public String multiply(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int[] result = new int[c1.length + c2.length];
        int si = c1.length + c2.length - 1;
        for (int i = c1.length - 1; i >= 0; i--) {
            int carry = 0;
            int offset = si;
            for (int j = c2.length - 1; j >= 0; j--) {
                int m = (c2[j] - '0') * (c1[i] - '0') + carry + result[offset];
                result[offset] = m % 10;
                carry = m / 10;
                offset--;
            }
            result[offset] = carry;
            si--;
        }
        boolean started = false;
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            if (started || i > 0) {
                started = true;
                sb.append(Integer.toString(i));
            }
        }
        if (sb.length() == 0) {
            return "0";
        } else {
            return sb.toString();
        }
    }
}
