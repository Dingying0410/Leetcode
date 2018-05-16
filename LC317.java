class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        int[][] reach = new int[m][n];
        int total = 0;
        int[] delta = {0, -1, 0, 1, 0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    total++;
                    boolean[][] visited = new boolean[m][n];
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i * n + j);
                    visited[i][j] = true;
                    int dis = 0;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        while (size-- > 0) {
                            int val = queue.poll();
                            int x = val / n;
                            int y = val % n;
                            distance[x][y] += dis;
                            reach[x][y]++;
                            for (int k = 0; k < delta.length - 1; k++) {
                                int xx = x + delta[k];
                                int yy = y + delta[k + 1];
                                if (xx >= 0 && xx < m && yy >= 0 && yy < n && grid[xx][yy] == 0 && !visited[xx][yy]) {
                                    queue.add(xx * n + yy);
                                    visited[xx][yy] = true;
                                }
                            }
                        }
                        dis++;
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == total) {
                    min = Math.min(min, distance[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE? -1 : min;
    }
}
