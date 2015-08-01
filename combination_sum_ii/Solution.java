package combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> r = combinationSum(candidates, 0, target);
        return new ArrayList<List<Integer>>(r);

    }

    HashSet<List<Integer>> combinationSum(int[] candidates, int idx, int target) {
        HashSet<List<Integer>> result = new HashSet<List<Integer>>();
        for (int i = idx; i < candidates.length; i++) {
            if (target == candidates[i]) {
                result.add(new ArrayList<Integer>(Arrays.asList(target)));
            } else if (target < candidates[i]) {
                break;
            } else {
                for (List<Integer> l : combinationSum(candidates, i + 1, target
                        - candidates[i])) {
                    l.add(0, candidates[i]);
                    result.add(l);
                }
            }
        }
        return result;
    }
}
