class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0)
            return;
        int m = rooms.length;
        int n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0)
                    dfs(rooms, i, j, m, n, 0);
            }
        }

    }

    public void dfs (int[][] rooms, int i, int j, int m, int n, int dis) {
        if (i < 0 || j < 0 || i == m || j == n || rooms[i][j] < dis) {
            return;
        }
        rooms[i][j] = dis;
        int[] delta = {0, -1, 0, 1, 0};
        for (int k = 0; k < delta.length - 1; k++) {
            dfs(rooms, i + delta[k], j + delta[k + 1], m, n, dis + 1);
        }
    }
}
