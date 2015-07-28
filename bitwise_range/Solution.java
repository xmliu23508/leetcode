package bitwise_range;

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        int x = m;
        int y = n;
        for (int i = 30; i >= 0; i--) {
            int d = 1 << i;
            if (Math.abs(m - n) >= d) {
                break;
            }
            if (x >= d && y >= d) {
                result += d;
            }
            x = x % d;
            y = y % d;
        }
        return result;
    }
}
