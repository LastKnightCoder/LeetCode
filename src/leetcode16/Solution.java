package leetcode16;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {

                int min = nums[i] + nums[start] + nums[start + 1];
                if (min > target) {
                    if (Math.abs(min - target) < Math.abs(closest - target)) {
                        closest = min;
                    }
                    break;
                }

                int max = nums[i] + nums[end] + nums[end - 1];
                if (max < target) {
                    if (Math.abs(max - target) < Math.abs(closest - target)) {
                        closest = max;
                    }
                    break;
                }

                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                if (sum - target == 0) {
                    closest = sum;
                    break;
                } else if (sum > target) {
                    end--;
                    while (start < end && nums[end] == nums[end + 1]) end--;
                } else {
                    start++;
                    while (start < end && nums[start] == nums[start - 1]) start++;
                }
                while (i < nums.length - 2 && nums[i] == nums[i + 1]) i++;
            }
        }

        return closest;
    }
}
