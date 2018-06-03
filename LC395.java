class Solution {
    public int longestSubstring(String s, int k) {
        return helper(0, s.length(), s, k);
    }

    public int helper (int start, int end, String s, int count) {
        if (start >= end)
            return 0;
        int[] map = new int[26];
        for (int j = start; j < end; j++) {
            map[s.charAt(j) - 'a']++;
        }
        int maxLen = 0;
        for (int j = start; j < end; j++) {
            while (j < end && map[s.charAt(j) - 'a'] < count)
                j++;
            int k = j;
            while (k < end && map[s.charAt(k) - 'a'] >= count)
                k++;
            if (j == start && k == end)
                return end - start;
            maxLen = Math.max(maxLen, helper(j, k, s, count));
            j = k - 1;
        }
        return maxLen;
    }
}
