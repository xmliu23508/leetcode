package next_permutation;

public class Solution {
    public void nextPermutation(int[] nums) {
        int r = nums.length - 1;
        while (r >= 1 && nums[r] <= nums[r - 1]) {
            r--;
        }
        if (r == 0) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int k = nums.length - 1;
            for (; k >= r && nums[k] <= nums[r - 1]; k--)
                ;
            swap(nums, k, r - 1);
            reverse(nums, r, nums.length - 1);
        }
    }

    void reverse(int[] nums, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
