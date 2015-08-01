package sudoku_solver;

public class Solution {
    public void solveSudoku(char[][] board) {
        int[] next = next(board, 0, 0);
        if (next == null) {
            return;
        } else {
            fill(board, next[0], next[1]);
        }
    }

    boolean fill(char[][] board, int x, int y) {
        for (int val = 1; val <= 9; val++) {
            board[x][y] = (char) (val + '0');
            if (isValid(board, x, 0, x, 8)
                    && isValid(board, 0, y, 8, y)
                    && isValid(board, 3 * (x % 3), 3 * (y % 3),
                            3 * (x % 3) + 2, 3 * (y % 3) + 2)) {
                int[] next = next(board, x, y);
                if (next == null) {
                    return true;
                } else {
                    if (fill(board, next[0], next[1])) {
                        return true;
                    }
                }
            }
            board[x][y] = '.';
        }
        return false;
    }

    int[] next(char[][] board, int x, int y) {
        for (int i = y; i <= 8; i++) {
            if (board[x][i] == '.') {
                return new int[] { x, i };
            }
        }
        for (int i = x + 1; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                if (board[i][j] == '.') {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    boolean isValid(char[][] board, int x1, int y1, int x2, int y2) {
        int[] buf = new int[10];
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (board[i][j] != '.') {
                    int n = board[i][j] - '0';
                    if (buf[n] > 0) {
                        return false;
                    } else {
                        buf[n] = 1;
                    }
                }
            }
        }
        return true;
    }
}