package search_insert_position;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (r == -1) {
            return 0;
        } else if (l == nums.length) {
            return nums.length;
        } else {
            return r + 1;
        }
    }
}
