class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= i; k++) {
                dp[i][i][k] = (k + 1) * (k + 1);
            }
        }
        for (int len = 1; len < n; len++) {
            for (int start = 0; start + len < n; start++) {
                int end = start + len;
                
                for (int k = 0; k <= start; k++) {
                    int temp = (k + 1) * (k + 1) + dp[start + 1][end][0];
                    for (int m = start + 1; m <= end; m++) {
                        if (boxes[m] == boxes[start]) {
                            temp = Math.max(temp, dp[start + 1][m - 1][0] + dp[m][end][k + 1]);
                        }
                    }
                    dp[start][end][k] = temp;
                }
                
            }
        }
        return (n == 0? 0 : dp[0][n - 1][0]);
    }
}