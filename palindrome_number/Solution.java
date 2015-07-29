package palindrome_number;

import junit.framework.TestCase;

public class Solution  extends TestCase{
    public boolean isPalindrome(int x) {
        int orig = x;
        int y=0;
        while(x>0) {
            y= y + (x%10);
            x=x/10;
        }
        return orig==y;
    }
    public void testSample() {
        assertTrue(this.isPalindrome(11));
    }
}
