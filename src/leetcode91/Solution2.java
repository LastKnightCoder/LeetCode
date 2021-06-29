package leetcode91;

public class Solution2 {
    public int numDecodings(String s) {
        int length = s.length();
        int cur;
        int pre = 0;
        if (s.charAt(0) == '0') {
            cur = 0;
        } else {
            cur = 1;
        }

        for (int i = 1; i < length; i++) {
            int temp = cur;
            if (s.charAt(i) == '0') {
                cur = 0;
            }
            int n = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
            if (n <= 26 && (s.charAt(i - 1) - '0') != 0) {
                cur = i > 1 ? cur + pre: cur + 1;
            }
            pre = temp;
        }

        return cur;
    }
}
