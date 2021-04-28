package leetcode69;

public class Solution {
    public int mySqrt(int x) {
        int start = 0;
        int end = x;
        while (start < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                break;
            } else if (mid * mid < x) {
                start = (int)++mid;
            } else {
                end = (int)--mid;
            }
        }
        return start + (end - start) / 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2147395599));
        System.out.println(Integer.MAX_VALUE);
    }
}
