class Solution {
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs("C", sb, grid, i, j, m, n);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    //Do a dfs, and give the shape of the island a string by appending the direction
    //Add the string to the set, when the dfs returns
    public void dfs (String dir, StringBuilder sb, int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i == m || j < 0 || j == n || grid[i][j] == 0) {
            return;
        }
        sb.append(dir + 1);
        grid[i][j] = 0;
        //East
        dfs("E", sb, grid, i, j + 1, m, n);
        //South
        dfs("S", sb, grid, i + 1, j, m, n);
        //West
        dfs("W", sb, grid, i, j - 1, m, n);
        //North
        dfs("N", sb, grid, i - 1, j, m, n);
        sb.append("B");
    }
}
