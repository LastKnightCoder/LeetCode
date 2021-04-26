package leetcode62;

public class Solution {
    public int uniquePaths(int m, int n) {
        // dp[i][j] 表示从 (0, 0) 到达 (i, j) 有多少种路径
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n -1];
    }
}
