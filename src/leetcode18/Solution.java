package leetcode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < 4) {
            return results;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    // 下面两个剪枝操作，速度可由 20ms 提升到 4ms
                    int min = nums[i] + nums[j] + nums[start] + nums[start + 1];
                    if (min > target) {
                        break;
                    }

                    int max = nums[i] + nums[j] + nums[end - 1] + nums[end];
                    if (target > max) {
                        break;
                    }

                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[start], nums[end]);
                        results.add(list);

                        while (start + 1 < end && nums[start] == nums[start + 1]) start++;
                        while (end - 1 > start && nums[end] == nums[end - 1]) end--;

                        start++;
                        end--;
                    } else if (sum < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        int target = 0;
        Solution solution = new Solution();
        System.out.println(solution.fourSum(nums, target));
    }
}
