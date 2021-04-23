package leetcode54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int m;
    private int n;
    private List<Integer> res = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        int start = 0;
        while (start < m - start && start < n - start) {
            spiralOrder(matrix, start++);
        }

        return res;
    }

    private void spiralOrder(int[][] matrix, int start) {
        for (int i = start; i < n - start; i++) {
            res.add(matrix[start][i]);
        }

        if (m - start - 1 > start) {
            for (int i = start + 1; i < m - start - 1; i++){
                System.out.println(n - 1 - start);
                res.add(matrix[i][n - 1 - start]);
            }
            for (int i = n - 1 - start; i >= start; i--) {
                res.add(matrix[m - 1 - start][i]);
            }
            if (n - 1 -start > start) {
                for (int i = m - 2 - start; i > start; i--) {
                    res.add(matrix[i][start]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}};
        Solution solution = new Solution();
        System.out.println(solution.spiralOrder(matrix));
    }
}

