package leetcode48;

public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int start = 0;
        int end = matrix.length - 1;
        while (start < end) {
            rotate(matrix, start++, end--);
        }
    }

    private void rotate(int[][] matrix, int start, int end) {
        for (int i = start; i < end; i++) {
            int temp = matrix[start][i];
            matrix[start][i] = matrix[end - i + start][start];
            matrix[end - i +  start][start] = matrix[end][end - i + start];
            matrix[end][end - i + start] = matrix[i][end];
            matrix[i][end] = temp;
        }
    }
}
