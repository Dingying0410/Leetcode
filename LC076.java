class Solution {
    public String minWindow(String s, String t) {
        int left = 0, min = Integer.MAX_VALUE, count = 0;
        int[] map = new int[256];
        int begin = -1;
        //count the characters, update count
        //if count = t.length, update min
        //right shift the left pointer
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]--;
        }
        for (int i = 0; i < s.length(); i++) {
            //update count when the character appears in T
            if (map[s.charAt(i)]++ < 0) {
                count++;
            }
            while (count == t.length()) {
                if (i - left + 1 < min) {
                    min = i - left + 1;
                    begin = left;
                }
                if (--map[s.charAt(left)] < 0) {
                    count--; //missing characters in T
                }
                left++;
            }
        }
        return min == Integer.MAX_VALUE? "" : s.substring(begin, begin + min);
    }
}