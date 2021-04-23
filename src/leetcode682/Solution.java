package leetcode682;

import java.util.Stack;

public class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op: ops) {
            switch (op) {
                case "+":
                    int lastOne = stack.pop();
                    int lastTwo = stack.peek();
                    int res = lastOne + lastTwo;
                    stack.push(lastOne);
                    stack.push(res);
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
