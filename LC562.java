class Solution {
    public int longestLine(int[][] M) {
        if (M.length == 0 || M[0].length == 0)
            return 0;
        int m = M.length;
        int n = M[0].length;
        int[][][] dp = new int[m][n][4];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    if (i > 0)
                        dp[i][j][0] = dp[i - 1][j][0] + 1;
                    if (j > 0)
                        dp[i][j][1] = dp[i][j - 1][1] + 1;
                    if (i > 0 && j > 0)
                        dp[i][j][2] = dp[i - 1][j - 1][2] + 1;
                    if (i > 0 && j < n - 1)
                        dp[i][j][3] = dp[i - 1][j + 1][3] + 1;
                    for (int k = 0; k < 4; k++) {
                        dp[i][j][k] = Math.max(dp[i][j][k], 1);
                        max = Math.max(max, dp[i][j][k]);
                    }
                }
                
            }
        }
        return max;
    }
}