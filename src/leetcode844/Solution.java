package leetcode844;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean backspaceCompare(String S, String T) {
        Deque<Character> stack1 = new LinkedList<>();
        for (char c: S.toCharArray()) {
            if (c != '#') {
                stack1.push(c);
                continue;
            }

            if (!stack1.isEmpty()) {
                stack1.poll();
            }
        }

        Deque<Character> stack2 = new LinkedList<>();
        for (char c: T.toCharArray()) {
            if (c != '#') {
                stack2.push(c);
                continue;
            }

            if (!stack2.isEmpty()) {
                stack2.poll();
            }
        }

        while (!(stack1.isEmpty() || stack2.isEmpty())) {
            if (stack1.poll() != stack2.poll()) {
                return false;
            }
        }

        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        String S = "ab##";
        String T =  "c#d#";

        Solution solution = new Solution();
        solution.backspaceCompare(S, T);
    }
}
