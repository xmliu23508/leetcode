package valid_sodoku;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] testset = new int[27][4];
        int k = 0;
        for (int i = 0; i < 9; i++) {
            testset[k++] = new int[] { 0, i, 8, i };
            testset[k++] = new int[] { i, 0, i, 8 };
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                testset[k++] = new int[] { i * 3, j * 3, i * 3 + 2, j * 3 + 2 };
            }
        }
        for (int[] t : testset) {
            if (!isValid(board, t[0], t[1], t[2], t[3])) {
                return false;
            }
        }
        return true;
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
