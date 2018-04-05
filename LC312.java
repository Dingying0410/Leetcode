class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        for (int len = 0; len < n; len++) {
            for (int start = 0; start + len < n; start++) {
                int end = start + len;
                for (int i = start; i <= end; i++) {
                    int max = nums[i] * getNum(nums, start - 1) * getNum(nums, end + 1);
                    //System.out.println(start + " " + end + " " + i + " " + max);
                    max += (i <= start? 0 : dp[start][i - 1]) + (i >= end? 0 : dp[i + 1][end]);
                    dp[start][end] = Math.max(dp[start][end], max);
                }
            }
        }
        return dp[0][n - 1];
    }
    
    public int getNum (int[] nums, int i) {
        if (i < 0 || i >= nums.length) 
            return 1;
        return nums[i];
    }
}