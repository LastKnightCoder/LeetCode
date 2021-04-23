package leetcode28;

public class Solution {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }

        if (haystack.length() == 0 || needle == null) {
            return -1;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i).startsWith(needle)) {
                return i;
            }
        }
        return -1;

    }
}
