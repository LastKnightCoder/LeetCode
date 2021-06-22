package leetcode79;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    private boolean[][] visited;
    private char[][] board;
    private String word;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (search(i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // 从 (i, j) 开始查找以 word[index] 开始的单词
    private boolean search(int i, int j, int index) {
        if (word.charAt(index) != board[i][j]) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;
        for (int[] next: adj(i, j)) {
            if (search(next[0], next[1], index + 1)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

    private List<int[]> adj(int i, int j) {
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        return Arrays.stream(dirs).map(item -> new int[]{i + item[0], j + item[1]})
                .filter(item -> item[0] >= 0
                        && item[0] < board.length
                        && item[1] >= 0
                        && item[1] < board[0].length
                        && !visited[item[0]][item[1]])
                .collect(Collectors.toList());
    }
}
