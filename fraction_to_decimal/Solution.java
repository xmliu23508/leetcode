package fraction_to_decimal;

import java.util.HashMap;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long a = (long) numerator;
        long b = (long) denominator;

        StringBuilder sb = new StringBuilder();
        sb.append(a * b < 0 ? "-" : "");
        a = Math.abs(a);
        b = Math.abs(b);
        sb.append(a / b);

        long r = a % b;
        if (r == 0) {
            return sb.toString();
        }
        sb.append(".");
        HashMap<Long, Integer> visited = new HashMap<Long, Integer>();
        while (r != 0) {
            if (visited.containsKey(r)) {
                sb.insert(visited.get(r), "(");
                sb.append(")");
                break;
            } else {
                visited.put(r, sb.length());
            }
            r = r * 10;
            sb.append(r / b);
            r = r % b;
        }
        return sb.toString();
    }
}
