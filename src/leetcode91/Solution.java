package leetcode91;

public class Solution {
    public int numDecodings(String s) {
        int length = s.length();
        int[] dp = new int[length];
        if (s.charAt(0) == '0') {
            dp[0] = 0;
        } else {
            dp[0] = 1;
        }

        for (int i = 1; i < length; i++) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }
            int n = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
            if (n <= 26) {
                dp[i] = i > 1 ? dp[i] + dp[i - 2]: dp[i] + 1;
            }
        }

        return dp[length - 1];
    }
}
