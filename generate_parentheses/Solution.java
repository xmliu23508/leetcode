package generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        return helper(n, n);
    }

    public List<String> helper(int left, int right) {
        List<String> result = new ArrayList<String>();
        if (left == 0 && right == 1) {
            result.add(")");
            return result;
        }

        if (left > 0) {
            for (String s : helper(left - 1, right)) {
                result.add("(" + s);
            }
        }

        if (left < right) {
            for (String s : helper(left, right - 1)) {
                result.add(")" + s);
            }
        }
        return result;
    }
}
