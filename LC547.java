class Solution {
    public int findCircleNum(int[][] M) {
        int m = M.length;
        boolean[] visited = new boolean[m];
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] == 1 && !visited[j]) {
                    res++;
                    dfs(i, visited, M);
                }
            }
        }
        return res;
    }
    
    public void dfs (int i, boolean[] visited, int[][] M) {
        for (int j = 0; j < M[i].length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(j, visited, M);
            }
        }
    }
}