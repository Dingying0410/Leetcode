class Solution {
    int res = 0;
    public int strobogrammaticInRange(String low, String high) {
        char[][] digits = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
        for (int i = low.length(); i <= high.length(); i++) {
            char[] chs = new char[i];
            generateNumbers(digits, chs, low, high, i, 0, i - 1);
        }
        return res;
    }
    
    public void generateNumbers (char[][] digits, char[] chs, String low, String high, int len, int left, int right) {
        if (left > right) {
            String s = new String(chs);
            if (len == low.length() && s.compareTo(low) < 0)
                return;
            if (len == high.length() && s.compareTo(high) > 0)
                return;
            res++;
            return;
        }
        for (char[] d : digits) {
            if (d[0] == '0' && left == 0 && right > left)
                continue;
            if ((d[0] == '6' || d[0] == '9') && left == right) 
                continue;
            chs[left] = d[0];
            chs[right] = d[1];
            generateNumbers(digits, chs, low, high, len, left + 1, right - 1);
        }
    }
}