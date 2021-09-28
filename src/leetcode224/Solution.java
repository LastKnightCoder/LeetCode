package leetcode224;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int calculate(String s) {
        s = s.replace(" ", "");
        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<String> ops = new LinkedList<>();
//        while (s.length() != 0) {
//
//        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(2 + 10) - 8 + 88";
        System.out.println(solution.calculate(s));
    }
}
