class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dp(1, n, dp);
    }

    public int dp (int start, int end, int[][] dp) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] != -1)
            return dp[start][end];
        int val = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            //Min means I play with the best strategy to minimize the cost
            //max means unfortunately I pick a number and has to go with the wrong path
            val = Math.min(i + Math.max(dp(start, i - 1, dp), dp(i + 1, end, dp)), val);
        }
        dp[start][end] = val;
        return dp[start][end];
    }
}
