package dungeon_game;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = getEnterValue(dungeon[m - 1][n - 1], 1);
        for (int x = m - 2; x >= 0; x--) {
            dp[x][n - 1] = getEnterValue(dungeon[x][n - 1], dp[x + 1][n - 1]);
        }
        for (int y = n - 2; y >= 0; y--) {
            dp[m - 1][y] = getEnterValue(dungeon[m - 1][y], dp[m - 1][y + 1]);
        }
        for (int x = m - 2; x >= 0; x--) {
            for (int y = n - 2; y >= 0; y--) {
                dp[x][y] = getEnterValue(dungeon[x][y],
                        Math.min(dp[x + 1][y], dp[x][y + 1]));
            }
        }
        return dp[0][0];

    }

    int getEnterValue(int cellValue, int exitValue) {
        return Math.max(-(cellValue - exitValue), 1);
    }
}