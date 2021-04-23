package leetcode45;

public class Solution2 {
    private int length;
    public int jump(int[] nums) {
        this.length = nums.length;
        return jump(nums, 0, 0);
    }

    private int jump(int[] nums, int curIndex, int counts) {
        if (curIndex > this.length - 1) {
            return Integer.MAX_VALUE;
        }

        if (curIndex == this.length - 1) {
            return counts;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[curIndex]; i++) {
            int t = jump(nums, curIndex + i, counts + 1);
            min = Math.min(t, min);
        }

        return min;
    }
}
