class Solution {
    public boolean isMatch(String s, String p) {
        //dp[i][j]: whether the first i characters of s match the first j characters of p
        //dp[i][j] = dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)
        //* : dp[i][j] = (dp[i - 1][j] && p.charAt(j - 2) == s.charAt(i - 1)) or dp[i][j - 2]
        //Initialization: dp[0][j] = true if *
        
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) || (dp[i][j - 2]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}