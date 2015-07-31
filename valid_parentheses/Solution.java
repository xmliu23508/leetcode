package valid_parentheses;

import java.util.ArrayDeque;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new  ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                Character top = stack.peek();
                if (top == '(' && s.charAt(i) == ')' || top == '['
                        && s.charAt(i) == ']' || top == '{'
                        && s.charAt(i) == '}') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
