package number_of_islands;

public class Solution {
    public int numIslands(char[][] grid) {
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    total++;
                    color(grid, i, j);
                }
            }
        }
        return total;
    }

    void color(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length
                || grid[x][y] != '1') {
            return;
        } else {
            grid[x][y] = '#';
            color(grid, x + 1, y);
            color(grid, x - 1, y);
            color(grid, x, y + 1);
            color(grid, x, y - 1);
        }
    }
}
