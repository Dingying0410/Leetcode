class Solution {
    class Point {
        String dir;
        int dis;
        int x;
        int y;
        
        public Point(int x, int y, int dis, String dir) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.dir = dir;
        }
    }
    
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length;
        int n = maze[0].length;
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
            public int compare (Point a, Point b) {
                if (a.dis != b.dis) {
                    return a.dis - b.dis;
                } else {
                    return a.dir.compareTo(b.dir);
                }
            }
        });
        Point[][] distance = new Point[m][n];
        for (int i = 0; i < m * n; i++) {
            distance[i / n][i % n] = new Point(i / n, i % n, Integer.MAX_VALUE, "");
            //distance[i / n][i % n].dis = Integer.MAX_VALUE;
        }
        pq.offer(new Point(ball[0], ball[1], 0, ""));
        int[] delta = {0, -1, 0, 1, 0};
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (distance[p.x][p.y].dis < p.dis || (distance[p.x][p.y].dis == p.dis && distance[p.x][p.y].dir.compareTo(p.dir) < 0)) {
                continue;
            }
            distance[p.x][p.y] = p;
            for (int k = 0; k < delta.length - 1; k++) {
                int xx = p.x + delta[k];
                int yy = p.y + delta[k + 1];
                int cur = p.dis;
                while (xx >= 0 && xx < m && yy >= 0 && yy < n && maze[xx][yy] == 0 && (xx != hole[0] || yy != hole[1] )){
                    xx += delta[k];
                    yy += delta[k + 1];
                    cur++;
                }
                if (!(xx == hole[0] && yy == hole[1])) {
                    xx -= delta[k];
                    yy -= delta[k + 1];
                }
                //System.out.println(xx + " " + yy + " " + cur);
                if (k == 0) {
                    pq.offer(new Point(xx, yy, cur, p.dir + "l"));
                } else if (k == 1) {
                    pq.offer(new Point(xx, yy, cur, p.dir + "u"));
                } else if (k == 2) {
                    pq.offer(new Point(xx, yy, cur, p.dir + "r"));
                } else if (k == 3) {
                    pq.offer(new Point(xx, yy, cur, p.dir + "d"));
                } 
            }
        }
        return distance[hole[0]][hole[1]].dis == Integer.MAX_VALUE? "impossible" : distance[hole[0]][hole[1]].dir;
    }
}