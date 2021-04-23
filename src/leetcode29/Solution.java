package leetcode29;

public class Solution {
    // 这里的解法很垃圾，参考题解
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }

        // Math.abs() 有 bug
        long s = dividend;
        long t = divisor;
        s = Math.abs(s);
        t = Math.abs(t);

        if (s >= Integer.MAX_VALUE && t == 1) {
            if (sign * s > 0) {
                return Integer.MAX_VALUE;
            } else {
                return s > Integer.MAX_VALUE ? Integer.MIN_VALUE : -Integer.MAX_VALUE;
            }
        }

        if (t >= Integer.MAX_VALUE) {
            return s < t ? 0 : sign * 1;
        }


        int rem = -1;
        while (s >= 0) {
            s -= t;
            rem++;
        }
        return sign * rem;
    }
}
