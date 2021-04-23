package leetcode14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        // 列比较法
        int index = 0;
        while (true) {
            if (index >= strs[0].length()) {
                return strs[0].substring(0, index);
            }
            char c = strs[0].charAt(index);
            for (String str: strs) {
                if (index >= str.length() || str.charAt(index) != c) {
                    return str.substring(0, index);
                }
            }
            index++;
        }

        // 行比较法
//        for (int i = 1; i < strs.length; i++) {
//            if ("".equals(maxPre)) {
//                return "";
//            }
//            int last = 0;
//            for (; last < Math.min(maxPre.length(), strs[i].length()); last++) {
//                if (maxPre.charAt(last) != strs[i].charAt(last)) {
//                    break;
//                }
//            }
//            maxPre = maxPre.substring(0, last);
//        }
//        return maxPre;

          // 行比较法，但是不知道为什么比上面的快，可能是数据特点引起的
//        for (String str: strs) {
//            while (!str.startsWith(maxPre)) {
//                if ("".equals(maxPre)) {
//                    return "";
//                }
//                maxPre = maxPre.substring(0, maxPre.length() - 1);
//            }
//        }

//        return maxPre;

    }
}
