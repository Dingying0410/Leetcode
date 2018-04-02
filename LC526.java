class Solution {
    int res;
    public int countArrangement(int N) {
        res = 0;
        boolean[] used = new boolean[N + 1];
        dfs(0, used, N);
        return res;
    }
    
    public void dfs (int index, boolean[] used, int N) {
        if (index == N) {
            res++;
            return;
        }
        for (int i = 1; i < used.length; i++) {
            if (!used[i] && (i % (index + 1) == 0 || (index + 1) % i == 0)) {
                used[i] = true;
                dfs(index + 1, used, N);
                used[i] = false;
            }
        }
    }
}