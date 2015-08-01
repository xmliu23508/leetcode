package longest_valid_parentheses;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        char[] a = s.toCharArray();
        int max = 0;
        int l = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '(') {
                stack.push(i);
            } else if (!stack.isEmpty()) {
                stack.pop();
                if (stack.isEmpty()) {
                    max = Math.max(max, i - l + 1);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            } else {
                l = i + 1;
            }
        }
        return max;
    }
}