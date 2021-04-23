package leetcode26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int size = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[size - 1] != nums[i]) {
                nums[size] = nums[i];
                size++;
            }
        }

        return size;
    }
}