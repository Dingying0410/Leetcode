//Given a string s, find the longest palindromic subsequence's length in s. 
//You may assume that the maximum length of s is 1000.
class Solution {
    public int longestPalindromeSubseq(String s) {
        //dp[i, j] = dp[i + 1, j - 1] + 1, if s.charAt(i) == s.charAt(j)
        //         = max(dp[i + 1, j], dp[i, j - 1]) otherwise
        //eg. abbcbba dp[0, 2] = max(dp[1, 2], dp[0, 1])
        if (s.length() == 0)
            return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        int max = 1;
        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                if (s.charAt(i) == s.charAt(i + len)) {
                    if (len == 1) {
                        dp[i][i + len] = 2;
                    } else {
                        dp[i][i + len] = dp[i + 1][i + len - 1] + 2;
                    }
                } else {
                    dp[i][i + len] = Math.max(dp[i + 1][i + len], dp[i][i + len - 1]);
                }
                max = Math.max(max, dp[i][i + len]);
            }
        }
        return max;
    }
}