class Solution {
    public boolean isNumber(String s) {
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = false;
        boolean pointSeen = false;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numberAfterE = true;
                numberSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen | !numberSeen) return false;
                numberAfterE = false;
                eSeen = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen)
                    return false;
                pointSeen = true;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e') return false;
            } else return false;
        }
        
        return numberSeen && numberAfterE;
    }
}