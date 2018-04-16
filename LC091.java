class Solution {
    public int numDecodings(String s) {
        //dp[i]: the number of ways to decode the first i characters
        //dp[i] += dp[i - 1] if ...
        //      += dp[i - 2] if ...
        if (s.length() == 0)
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one > 0)
                dp[i] += dp[i - 1];
            if (i > 1) {
                int two = Integer.valueOf(s.substring(i - 2, i));
                if (two >= 10 && two <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }
}