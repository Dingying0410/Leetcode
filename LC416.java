class Solution {
    //dp[sum][j]: if the first j numbers can add up to sum
    //dp[sum][j] = dp[sum - nums[j]][j - 1] || dp[sum][j - 1]
    //dp[0][j] = true for all j
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        sum /= 2;
        int n = nums.length;
        boolean[][] dp = new boolean[sum + 1][n + 1];
        for (int j = 0; j < n; j++) {
            dp[0][j] = true;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i - nums[j - 1] >= 0)
                    dp[i][j] |= dp[i - nums[j - 1]][j - 1];
            }
        }
        return dp[sum][n];
    }
}