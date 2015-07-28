package largest_number;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
        Integer[] a = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[i] = nums[i];
        }
        Arrays.sort(a, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                return (x.toString() + y.toString()).compareTo(y.toString()
                        + x.toString());
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) {
            sb.append(a[i]);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        } else {
            return sb.toString();
        }
    }
}
