package leetcode69;

public class Solution2 {
    public int mySqrt(int a) {
        double x = 0.1;
        double pre = 0;
        while (Math.abs(x - pre) > 1e-5) {
            pre = x;
            x = 0.5 * (x + a/x);
        }

        return (int)x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().mySqrt(8));
    }
}
