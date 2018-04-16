class Solution {
    public int uniquePaths(int m, int n) {
        //dp[i][j]: from (0, 0) to (i, j)
        //dp[i][j] = dp[i - 1][j] + dp[i][j - 1] -> dp[j] = dp[j] + dp[j - 1]
        if (m == 0 || n == 0)
            return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}