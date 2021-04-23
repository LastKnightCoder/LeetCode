package leetcode55;

public class Solution {
    public boolean canJump(int[] nums) {
        int l = nums.length;
        boolean[] dp = new boolean[l];
        dp[l - 1] = true;

        for (int i = l - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                dp[i] = false;
                continue;
            }
            if (nums[i] + i >= l - 1) {
                dp[i] = true;
            } else {
                for (int j = 1; j <= nums[i]; j++) {
                    dp[i] = dp[i] || dp[i + j];
                    if (dp[i]) {
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}
