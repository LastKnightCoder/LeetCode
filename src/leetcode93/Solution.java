package leetcode93;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> results = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        // 长度不够，直接返回
        if (s.length() < 4) {
            return results;
        }
        restoreIpAddresses(s, new ArrayList<>());
        return results;
    }

    /**
     *
     * @param leftString 剩余未处理的字符串
     * @param ip 保存ip地址的各个部分，如 [1, 1, 1] [255, 255, 1, 3]
     */
    private void restoreIpAddresses(String leftString, List<String> ip) {
        // ip 超过四个部分，无效
        if (ip.size() > 4) {
            return;
        }

        // 长度不够或者超出，无效
        int leftL = leftString.length();
        if (leftL < (4 - ip.size()) || leftL > (4 - ip.size()) * 3) {
            return;
        }

        // 字符串处理完毕，并且ip中正好有四个部分，取出ip中的元素拼接
        if (ip.size() == 4 && leftL == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < ip.size(); i++) {
                stringBuilder.append(ip.get(i));
                if (i != ip.size() - 1) {
                    stringBuilder.append(("."));
                }
            }
            results.add(stringBuilder.toString());
            return;
        }

        // 有未处理的字符串，递归调用
        // 为了防止 subString 调用异常，需要判断剩余未处理字符串与 3 的大小，这个 3 表示 ip 中每个部分最大的长度
        for (int i = 1; i <= Math.min(3, leftL); i++) {
            String str = leftString.substring(0, i);
            // 如果取出的字符串是无效的，则后面的也是无效的，直接推出循环
            if (!isValidIp(str)) {
                break;
            }
            ip.add(str);
            restoreIpAddresses(leftString.substring(i), ip);
            ip.remove(ip.size() - 1);
        }
    }

    /**
     * 判断输入的字符串是否为有效的ip组成部分
     * @param s 字符串，如 255 18 7777
     * @return 布尔值，是否是有效ip组成
     */
    private boolean isValidIp(String s) {
        // 长度不对，肯定不是
        int l = s.length();
        if (l < 1 || l > 3) {
            return false;
        }
        // 大小范围不对，肯定不是，如 278
        int n = Integer.parseInt(s);
        if (n < 0 || n > 255) {
            return false;
        }

        // 有前置的0，也不是，如 09, 024, 007
        if (l == 2 && n <= 9) {
            return false;
        } else if (l == 3 && n <= 99) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> list = new Solution().restoreIpAddresses(s);
        System.out.println(list); // [255.255.11.135, 255.255.111.35]
    }
}
