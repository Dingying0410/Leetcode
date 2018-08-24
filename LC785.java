class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!dfs(i, graph, colors, 0))
                    return false;
            }
        }
        return true;
    }

    public boolean dfs(int cur, int[][] graphs, int[] colors, int color) {
        if (colors[cur] != -1) {
            return colors[cur] == color;
        }
        colors[cur] = color;
        //if (colors[cur] != color) return false;
        for (int next : graphs[cur]) {
            if (!dfs(next, graphs, colors, 1 - color))
                return false;
        }
        return true;
    }
}
