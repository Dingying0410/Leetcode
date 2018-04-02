class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>(){
            public int compare (String s1, String s2) {
                if (s2.length() != s1.length())
                    return s2.length() - s1.length();
                else 
                    return s1.compareTo(s2);
            }
        });
        for (String t : d) {
            if (contains(s, t)) {
                return t;
            }
        }
        return "";
    }
    
    public boolean contains (String s, String t) {
        int idx = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (s.indexOf(c, idx) == -1)
                return false;
            idx = s.indexOf(c, idx) + 1;
        }
        return true;
    }
}