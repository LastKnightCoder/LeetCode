package leetcode50;

public class Solution2 {
    private double MyPowWithPositiveExp(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double res = 1;
        for (int i = 0; i < n; i++) {
            res *= x;
        }

        return res;
    }
}
