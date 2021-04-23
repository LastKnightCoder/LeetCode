package leetcode36;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        return validateRow(board) && validateColumn(board) && validate3By3(board);
    }

    private boolean validateRow(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            Set<Character> set = new HashSet<>();
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == '.') {
                    continue;
                }

                if (!set.contains(board[row][column])) {
                    set.add(board[row][column]);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean validateColumn(char[][] board) {
        for (int column = 0; column < board[0].length; column++) {
            Set<Character> set = new HashSet<>();
            for (int row = 0; row < board.length; row++) {
                if (board[row][column] == '.') {
                    continue;
                }
                if (!set.contains(board[row][column])) {
                    set.add(board[row][column]);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean validate3By3(char[][] board) {
        for (int row = 0; row < board.length; row += 3) {
            for (int column = 0; column < board[0].length; column += 3) {
                Set<Character> set = new HashSet<>();
                for (int i = row; i < row + 3; i++) {
                    for (int j = column; j < column + 3; j++) {
                        if (board[i][j] == '.') {
                            continue;
                        }
                        if (!set.contains(board[i][j])) {
                            set.add(board[i][j]);
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
