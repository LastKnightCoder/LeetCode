package leetcode12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public String intToRoman(int num) {
//        String[][] maps = new String[4][];
//        maps[0] = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
//        maps[1] = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
//        maps[2] = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
//        maps[3] = new String[]{"", "M", "MM", "MMM"};
//
//        StringBuilder stringBuilder = new StringBuilder();
//        Stack<String> stack = new Stack();
//        int index = 0;
//        while (num != 0) {
//            int n = num % 10;
//            num /= 10;
//            stack.push(maps[index][n]);
//            index++;
//        }
//
//        while (!stack.isEmpty()) {
//            stringBuilder.append(stack.pop());
//        }
//
//        return stringBuilder.toString();

        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roma = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0) {
            if (num >= nums[index]) {
                stringBuilder.append(roma[index]);
                num -= nums[index];
                continue;
            }
            index++;
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        new Solution().intToRoman(1984);
    }
}