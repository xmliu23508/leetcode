package search_for_a_range;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                int[] result = new int[2];
                for (int i = m; i >= 0 && nums[i] == target; i--) {
                    result[0] = i;
                }
                for (int i = m; i < nums.length && nums[i] == target; i++) {
                    result[1] = i;
                }
                return result;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return new int[] { -1, -1 };
    }
}
