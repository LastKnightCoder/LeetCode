package leetcode13;

public class Solution {
    public int romanToInt(String s) {
//        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//        String[] roma = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//        int index = 0;
//        int sum = 0;
//        while (!"".equals(s)) {
//            if (s.startsWith(roma[index])) {
//                sum += nums[index];
//                s = s.substring(roma[index].length());
//                continue;
//            }
//            index++;
//        }
//
//        return sum;
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");

        int sum = 0;
        for (char c: s.toCharArray()) {
            sum += romaToNum(c);
        }

        return sum;
    }

    private int romaToNum(char c) {
        switch (c) {
            case 'I' : return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
            default: return 0;
        }
    }
}
