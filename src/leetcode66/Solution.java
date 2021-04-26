package leetcode66;

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            System.out.println("i: " + i);
            int n = digits[i] + carry;
            if (i == digits.length - 1) {
                n = n + 1;
            }

            if (n >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }

            digits[i] = n % 10;
            if (carry == 0) {
                break;
            }
        }
        if (carry == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res[i] = 0;
            }
            return res;
        } else {
            return digits;
        }

    }

    public static void main(String[] args) {
        int[] digits = new int[]{9, 8, 9};
        Solution solution = new Solution();
        int[] res = solution.plusOne(digits);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
