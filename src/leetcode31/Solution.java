package leetcode31;

public class Solution {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length -1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                // 翻转
                for (int j = i; j < (i + nums.length) / 2; j++) {
                    swap(nums, j, nums.length - 1 + i - j);
                }
                // 选择其中第一个比 num[i-1] 小的，交换
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, i - 1, j);
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < nums.length / 2; i++) {
            swap(nums, i, nums.length - 1 - i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
