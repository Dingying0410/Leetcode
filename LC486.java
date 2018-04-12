class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dp(0, n - 1, dp, nums) >= 0;
    }
    
    public int dp(int left, int right, int[][] dp, int[] nums) {
        if (left == right)
            return nums[left];
        if (dp[left][right] == -1) {
            dp[left][right] = Math.max(nums[left] - dp(left + 1, right, dp, nums), nums[right] - dp(left, right - 1, dp, nums));
        }
        return dp[left][right];
    }
}