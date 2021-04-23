package leetcode45;

import java.util.Arrays;

public class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
                continue;
            }
            if (nums[i] + i >= nums.length - 1) {
                dp[i] = 1;
            } else {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 1; j <= nums[i]; j++) {
                    if (dp[i + j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[i + j] + 1);
                    }
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
//        int[] nums = {2, 0, 2, 4, 6, 0, 0, 3};
        int[] nums = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        Solution solution = new Solution();
        System.out.println(solution.jump(nums));
    }
}
