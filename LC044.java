class Solution {
    public boolean isMatch(String s, String p) {
        //dp[i][j]: whether the first i characters in s match the first j characters of p
        //if * : dp[i][j] = dp[i][j - 1] (* matches nothing) || dp[i - 1][j]
        //if not *: dp[i][j] = dp[i - 1][j - 1] and match current bits
        int len1 = s.length();
        int len2 = p.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || '?' == p.charAt(j - 1));
                }
            }
        }
        return dp[len1][len2];
    }
}