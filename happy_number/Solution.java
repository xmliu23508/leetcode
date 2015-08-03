package happy_number;

import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet<Integer>();
        while (!visited.contains(n)) {
            visited.add(n);
            if (n == 1)
                return true;
            int sum = 0;
            while (n > 0) {
                sum = sum + (n % 10) * (n % 10);
                n = n / 10;
            }
            n = sum;
        }
        return false;
    }
}
