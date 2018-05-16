class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int max = 0;
        int row = 0;
        int[] cols = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') row = countEnemiesOfRow(grid, i, j);
                if (i == 0 || grid[i - 1][j] == 'W') cols[j] = countEnemiesOfCol(grid, i, j);
                if (grid[i][j] == '0')
                    max = Math.max(row + cols[j], max);
            }
        }
        return max;
    }

    public int countEnemiesOfRow (char[][] grid, int row, int col) {
        int sum = 0;
        for (int j = col; j < grid[row].length; j++) {
            if (grid[row][j] == 'W')
                break;
            if (grid[row][j] == 'E')
                sum++;
        }
        return sum;
    }

    public int countEnemiesOfCol (char[][] grid, int row, int col) {
        int sum = 0;
        for (int i = row; i < grid.length; i++) {
            if (grid[i][col] == 'W')
                break;
            if (grid[i][col] == 'E')
                sum++;
        }
        return sum;
    }
}
