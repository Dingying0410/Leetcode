class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || maze[0].length == 0)
            return false;
        Queue<Integer> queue = new LinkedList<>();
        int m = maze.length;
        int n = maze[0].length;
        int[] delta = {0, -1, 0, 1, 0};
        queue.offer(start[0] * n + start[1]);
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true; 
        while (!queue.isEmpty()) {
            int val = queue.poll();
            int x = val / n;
            int y = val % n;
            for (int k = 0; k < delta.length - 1; k++) {
                int xx = delta[k] + x;
                int yy = delta[k + 1] + y;
                while (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0) {
                    xx += delta[k];
                    yy += delta[k + 1];
                }
                xx -= delta[k];
                yy -= delta[k + 1];
                if (xx == destination[0] && yy == destination[1])
                    return true;
                if (!visited[xx][yy]) {
                    queue.offer(xx * n + yy);
                    visited[xx][yy] = true;
                }
                
            }
        }
        return false;
    }
}