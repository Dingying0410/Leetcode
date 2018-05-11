class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        return match(pattern, str, 0, 0, new HashMap<Character, String>(), new HashSet<String>());
    }

    public boolean match(String pattern, String str, int i, int j, Map<Character, String> map, Set<String> set) {
        if (i == pattern.length() && j == str.length())
            return true;
        if (i == pattern.length() || j == str.length())
            return false;
        char c = pattern.charAt(i);
        if (!map.containsKey(c)) {
            for (int len = 1; j + len <= str.length(); len++) {
                String sub = str.substring(j, j + len);
                if (set.contains(sub))
                    continue;
                set.add(sub);
                map.put(c, sub);
                if (match(pattern, str, i + 1, j + len, map, set))
                    return true;
                set.remove(sub);
                map.remove(c);
            }
        } else {
            if (!str.substring(j).startsWith(map.get(c)))
                return false;
            return match(pattern, str, i + 1, j + map.get(c).length(), map, set);
        }
        return false;
    }
}
