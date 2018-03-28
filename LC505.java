class Solution {
    class Point {
        int x;
        int y;
        int dis;
        
        public Point(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        //check boundary conditions
        if (maze.length == 0 || maze[0].length == 0) 
            return -1;
        int m = maze.length;
        int n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int i = 0; i < distance.length; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>(){
            public int compare (Point a, Point b) {
                return a.dis - b.dis;
            }
        });
        pq.offer(new Point(start[0], start[1], 0));
        int[] delta = {0, -1, 0, 1, 0};
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (distance[p.x][p.y] <= p.dis)
                continue;
            distance[p.x][p.y] = p.dis;
            for (int i = 0; i < delta.length - 1; i++) {
                int x = p.x + delta[i];
                int y = p.y + delta[i + 1];
                int dis = p.dis;
                while (x < m && x >= 0 && y < n && y >= 0 && maze[x][y] == 0) {
                    dis++;
                    x += delta[i];
                    y += delta[i + 1];
                }
                x -= delta[i];
                y -= delta[i + 1];
                pq.offer(new Point(x, y, dis));
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE? -1 : distance[destination[0]][destination[1]];
    }
}