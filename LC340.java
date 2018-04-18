class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int distinct = 0;
        int[] map = new int[256];
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)]++ == 0) {
                distinct++;
            }
            while (distinct > k) {
                if (--map[s.charAt(left++)] == 0) {   
                    distinct--;
                }
            }
            if (distinct <= k) {
                max = Math.max(i - left + 1, max);
            }
        }
            
        return max;
    }
}