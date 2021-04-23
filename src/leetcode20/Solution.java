package leetcode20;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        char[] strs = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char c: strs) {
            if (stack.isEmpty() && (c == ')' || c == ']' || c == '}')) {
                return false;
            }

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if ((c == ')' && stack.peek() != '(') || (c == ']' && stack.peek() != '[' || (c == '}' && stack.peek() != '{'))) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()"));
    }
}
