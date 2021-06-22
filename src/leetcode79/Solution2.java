package leetcode79;

import java.util.List;

public class Solution2 {
    private boolean[][] visited;
    private char[][] board;
    private String word;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[0].length; j++) {
                if (!visited[i][j]) {
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
        char c = word.charAt(index);
        if (c != board[i][j]) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        for (int[] next: dirs) {
            int newX = i + next[0];
            int newY = j + next[1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && !visited[newX][newY]) {
                if (search(newX, newY, index + 1)) {
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }
}
