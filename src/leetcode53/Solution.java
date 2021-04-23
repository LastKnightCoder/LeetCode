package leetcode53;

public class Solution {
    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            if (dp < 0) {
                dp = nums[i];
            } else {
                dp = dp + nums[i];
            }

            if (dp > max) {
                max = dp;
            }
        }

        return max;
    }
}
