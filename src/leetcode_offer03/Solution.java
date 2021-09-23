package leetcode_offer03;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                int index = nums[i];
                if (nums[i] == nums[index]) {
                    return nums[i];
                }
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                i--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findRepeatNumber(new int[]{0, 1, 2, 3, 2, 4}));
    }
}
