class Solution {
    public int change(int amount, int[] coins) {
        //dp[i][j]: the number of ways to get i using the first j coins
        //eg. amount = 5, coins = [1, 2, 5]
        //dp[i][j] = dp[i][j - 1] (not take coins[j]) + dp[i - coins[j]][j] (take coins[j])
        //dp[5][3] = dp[5][2] + dp[0][3] = 3 + 1 = 4
        //dp[5][2] = dp[5][1] + dp[3][2] = 1 + 2 = 3
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int j = 0; j <= coins.length; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= coins.length; j++) {
                dp[i][j] = dp[i][j - 1] + (i - coins[j - 1] >= 0? dp[i - coins[j - 1]][j] : 0);
            }
        }
        return dp[amount][coins.length];
    }


    //Method with space complexity optimization
    public int change2(int amount, int[] coins) {

        //dp[i][j]: the number of ways to get i using the first j coins
        //eg. amount = 5, coins = [1, 2, 5]
        //dp[i][j] = dp[i][j - 1] (not take coins[j]) + dp[i - coins[j]][j] (take coins[j])
        //dp[5][3] = dp[5][2] + dp[0][3] = 3 + 1 = 4
        //dp[5][2] = dp[5][1] + dp[3][2] = 1 + 2 = 3
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int j = 1; j <= coins.length; j++) {
            for (int i = 1; i <= amount; i++) {
                dp[i] = dp[i] + (i >= coins[j - 1]? dp[i - coins[j - 1]] : 0);
            }
        }
        return dp[amount];
    }
}

//dp[i][j]: the number of ways to get i using the first j coins
//At each step, to get amount i we can refuse to take the coin j or take coin j
//dp[i][j] = dp[i][j - 1] + dp[i - coins[j - 1]][j]

