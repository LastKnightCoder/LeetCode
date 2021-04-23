package leetcode50;

public class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        double res = myPowWithPositiveExp(x, Math.abs(n));
        return n > 0 ? res : 1/res;
    }

    private double myPowWithPositiveExp(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double res = myPowWithPositiveExp(x, n/2);
        if (n % 2 == 0) {
            return res *res;
        } else {
            return x * res * res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2, -3));
    }
}
