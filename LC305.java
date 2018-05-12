class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[] roots = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            roots[i] = -1;
        }
        int islands = 0;
        int[] delta = {0, -1, 0, 1, 0};
        for (int i = 0; i < positions.length; i++) {
            islands++;
            int x = positions[i][0];
            int y = positions[i][1];
            int root = x * n + y;
            roots[x * n + y] = root;
            for (int k = 0; k < delta.length - 1; k++) {
                int xx = x + delta[k];
                int yy = y + delta[k + 1];
                if (xx >= 0 && xx < m && yy >= 0 && yy < n && roots[xx * n + yy] != -1) {
                    int rootNb = findRoot(roots, xx * n + yy);
                    if (rootNb != root) {
                        islands--;
                        roots[rootNb] = root;
                    }
                }
            }
            res.add(islands);
        }
        return res;
    }

    public int findRoot(int[] roots, int i) {
        if (roots[i] == i || roots[i] == -1) {
            return i;
        }
        return findRoot(roots, roots[i]);
    }
}
