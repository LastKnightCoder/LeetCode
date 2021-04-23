package leetcode11;

public class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max= 0;
        while (start < end) {
            int s = (end - start) * Math.min(height[start], height[end]);
            if (max < s) {
                max = s;
            }
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return max;
    }
}
