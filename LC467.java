class Solution {
    public int findSubstringInWraproundString(String p) {
        //dp[i]: the number of substrings ending with p.charAt(i) in the wraparound string
        //dp[i] = 1 initially
        //dp[i] += dp[i - 1] if s.charAt(i) - s.charAt(i - 1) == 1
        int[] dp = new int[26];
        int sum = 0;
        int cur = 1;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i) - p.charAt(i - 1) + 26 == 1)) {
                cur++;
            } else {
                cur = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], cur);
        }
        for (int i = 0; i < 26; i++) {
            sum += dp[i];
        }
        return sum;
    }
}