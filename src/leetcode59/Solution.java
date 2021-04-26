package leetcode59;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        int start = 0;
        while (start <= n/2) {
            for (int i = start; i < n - start; i++) {
                matrix[start][i] = count++;
            }
            if (n - start - 1 > start) {
                for (int i = start + 1; i < n - start - 1; i++) {
                    matrix[i][n - start - 1] = count++;
                }
                for (int i = n - start - 1; i >= start; i--) {
                    matrix[n - start - 1][i] = count++;
                }
                for (int i = n - start - 2; i > start; i--) {
                    matrix[i][start] = count++;
                }
            }
            start++;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new Solution().generateMatrix(4);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println("");
        }
    }
}
