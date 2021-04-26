package leetcode67;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public String addBinary(String a, String b) {
        // 保证 a 的长度比 b 的长，统一处理
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        int la = a.length();
        int lb = b.length();

        List<Integer> res = new ArrayList<>();
        // 进位
        int carry = 0;
        for (int i = 0; i < la; i++) {
            int n = a.charAt(la - 1 - i) - '0' + carry;
            if (i < lb) {
                n += b.charAt(lb - 1 - i) - '0';
            }
            carry = n >= 2 ? 1 : 0;
            res.add(n % 2);
        }

        // 溢出，添加一位
        if (carry == 1) {
            res.add(1);
        }

        // 将 List 转为 String
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = res.size() - 1; i >= 0; i--) {
            stringBuilder.append(res.get(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String a = "111";
        String b = "1";

        System.out.println(new Solution().addBinary(a, b));
    }
}
