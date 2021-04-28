package leetcode75;

// 快速排序的 partition 算法
public class Solution {
    public void sortColors(int[] nums) {
        int left = -1;
        int cur = 0;
        int right = nums.length;

        while (cur < right) {
            if (nums[cur] == 0) {
                swap(nums, ++left, cur++);
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                swap(nums, --right, cur);
            }
        }
    }
    private void swap(int[] nums,int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
