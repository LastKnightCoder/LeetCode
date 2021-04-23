package leetcode33;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }
        // 找到分界点
        int start = 0;
        int end = nums.length - 1;
        int k = start;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= nums[start]) {
                start = mid + 1;
                if (nums[mid + 1] < nums[mid]) {
                    k = mid + 1;
                    break;
                }
            } else {
                end = mid - 1;
                if (nums[mid - 1] > nums[mid]) {
                    k = mid;
                    break;
                }
            }
        }

        if (k == 0) {
            if (target < nums[0] || target > nums[nums.length - 1]) {
                return -1;
            }
            return findIndex(nums, 0, nums.length - 1, target);
        }

        if (target > nums[k - 1] || target < nums[k]) {
            return -1;
        }

        return target >= nums[0] ? findIndex(nums, 0, k - 1, target) : findIndex(nums, k, nums.length - 1, target);
    }

    private int findIndex(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        Solution solution = new Solution();
        System.out.println(solution.search(nums, 1));
    }
}
