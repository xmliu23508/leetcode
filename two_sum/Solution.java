package two_sum;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            if (map.get(target-nums[i])!=null) {
                result[0]=map.get(target-nums[i]);
                result[1]=i+1;
                break;
            }
            else {
                map.put(nums[i],i+1);
            }
        }
        return result;
    }
}
