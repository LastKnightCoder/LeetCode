package leetcode34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int start = 0;
        int end = nums.length - 1;
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (index == -1) {
            return new int[]{-1, -1};
        }

        int left = index;
        while (left - 1 >= 0 && nums[left - 1] == target) {
            left--;
        }
        int right = index;
        while (right + 1 < nums.length && nums[right + 1] == target) {
            right++;
        }

        return new int[]{left, right};
    }
}
