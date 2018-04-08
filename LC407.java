class Solution {
    class Rect {
        int i;
        int j;
        int height;
        
        public Rect(int i, int j, int height) {
            this.i = i;
            this.j = j;
            this.height = height;
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap[0].length == 0)
            return 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        //visited: we cannot collect water here (because it is at the boundary or we have visited it before)
        PriorityQueue<Rect> pq = new PriorityQueue<>(new Comparator<Rect>(){
            public int compare (Rect a, Rect b) {
                return a.height - b.height;
            }
        });
        for (int i = 0; i < m; i++) {
            pq.offer(new Rect(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            pq.offer(new Rect(i, n - 1, heightMap[i][n - 1]));
            visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new Rect(0, j, heightMap[0][j]));
            visited[0][j] = true;
            pq.offer(new Rect(m - 1, j, heightMap[m - 1][j]));
            visited[m - 1][j] = true;
        }
        int[] delta = {0, -1, 0, 1, 0};
        int res = 0;
        int max = 0;
        while (!pq.isEmpty()) {
            Rect cur = pq.poll();
            int x = cur.i;
            int y = cur.j;
            for (int i = 0; i < delta.length - 1; i++) {
                int xx = x + delta[i];
                int yy = y + delta[i + 1];
                if (xx < 0 || xx == m || yy < 0 || yy == n || visited[xx][yy])
                    continue;
                max = Math.max(cur.height, max);
                if (heightMap[xx][yy] < max)
                    res += max - heightMap[xx][yy];
                pq.offer(new Rect(xx, yy, heightMap[xx][yy]));
                visited[xx][yy] = true;
            }
        }
        return res;
        
    }
}