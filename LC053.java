class Solution {
    //dp[i]: the maximum sum ending with nums[i]
    //eg. -2, 1, 3
    //dp[0] = -2, dp[1] = 1, dp[2] = 4
    //dp[i] = Math.max(dp[i - 1], 0) + nums[i]
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Math.max(i == 0? 0 : dp[i - 1], 0) + nums[i];
            max = Math.max(dp[i], max);
        }
        return max == Integer.MIN_VALUE? 0 :max;
    }
}