package leetcode70;

public class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int first = 1;
        int second = 2;
        for (int i = 2; i < n; i++) {
            int temp = second;
            second = first + second;
            first = temp;
        }

        return second;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(4));
    }
}
