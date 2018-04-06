//Dynamic programming
//dp[i][j][N]: the number of paths to move from (i, j) to outside using N times
//Time: O(N * m * n)
//Space: O(m * n) improved from O(m * n * N)

class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        //dp[i][j][N]: the number of paths to move from (i, j) to outside using N times
        //dp[i][j][N] = sum(dp[a][b][N - 1])
        long[][] dp = new long[m][n];
        long[][] temp = dp;
        final int mod = (int)Math.pow(10, 9) + 7;
        for (int k = 1; k <= N; k++) {
            dp = new long[m][n];
            for (int ii = 0; ii < m; ii++) {
                for (int jj = 0; jj < n; jj++) {
                    dp[ii][jj] += ii == 0? 1 : temp[ii - 1][jj];
                    dp[ii][jj] += ii == m - 1? 1 : temp[ii + 1][jj];
                    dp[ii][jj] += jj == 0? 1 : temp[ii][jj - 1];
                    dp[ii][jj] += jj == n - 1? 1 : temp[ii][jj + 1];
                    dp[ii][jj] %= mod;
                }
            }
            temp = dp;
        }
        return (int)dp[i][j];
    }
    
}