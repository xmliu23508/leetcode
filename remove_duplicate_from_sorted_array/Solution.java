package remove_duplicate_from_sorted_array;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[i++] = nums[j];
            }
        }
        return i;

    }
}