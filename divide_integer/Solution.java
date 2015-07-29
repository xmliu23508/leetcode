package divide_integer;

import junit.framework.TestCase;

public class Solution extends TestCase {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return 2147483647;
        }
        boolean positive = (1l * dividend * divisor >= 0);
        long x = Math.abs((long) dividend);
        long y = Math.abs((long) divisor);

        long remainder = x;
        long result = 0;
        while (remainder >= y) {
            int i = 0;
            while (remainder >= (y << (i + 1))) {
                i++;
            }
            result = result + (1l << i);
            remainder = remainder - (y << i);
        }
        result = positive ? result : -result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 2147483647;
        }
        return (int) result;
    }

    public void testSample() {
        assertEquals(0, this.divide(-1010369383, -2147483648));
    }
}
