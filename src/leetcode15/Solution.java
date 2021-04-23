package leetcode15;

import java.util.*;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < 3) {
            return results;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            if (target > 0) {
                break;
            }
            if (i + 2 >= nums.length) {
                break;
            }

            if (i > 0 && nums[i - 1] == nums[i]) continue;

            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] == -target) {
                    List<Integer> res = new ArrayList<>();
                    res.add(target);
                    res.add(nums[start]);
                    res.add(nums[end]);
                    results.add(res);

                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;

                    start++;
                    end--;

                } else if (nums[start] + nums[end] < -target) {
                    start++;
                } else {
                    end--;
                }
            }

        }

        return results;

    }

    public static void main(String[] args) {
        int[] nums = {1,-1,-1,0};
        System.out.println(new Solution().threeSum(nums));
    }


}
