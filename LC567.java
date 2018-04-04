class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        if (s2.length() < s1.length())
            return false;
        for (int i = 0; i < s1.length(); i++) {
            map[s1.charAt(i) - 'a']++;
            map[s2.charAt(i) - 'a']--;
        }
        int diff = diff(map);
        if (diff == 0)
            return true;
        
        for (int i = 1; i + s1.length() <= s2.length(); i++) {
            map[s2.charAt(i - 1) - 'a']++;
            map[s2.charAt(i + s1.length() - 1) - 'a']--;
            if (diff(map) == 0)
                return true;
        }
        return false;
    }
    
    public int diff (int[] map) {
        int diff = 0;
        for (int i = 0; i < map.length; i++) {
            diff += Math.abs(map[i]);
        }
        return diff;
    }
}