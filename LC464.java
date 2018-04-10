class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal == 0)
            return true;
        if (((1 + maxChoosableInteger) * maxChoosableInteger / 2) < desiredTotal)
            return false;
        Map<Integer, Boolean> map = new HashMap<>();
        boolean[] used = new boolean[maxChoosableInteger + 1];
        return helper(desiredTotal, used, map);
    }
    
    public boolean helper (int total, boolean[] used, Map<Integer, Boolean> map) {
        if (total <= 0)
            return false;
        int format = format(used);
        boolean res = false;
        if (!map.containsKey(format)) {
            for (int i = 1; i < used.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    if (!helper(total - i, used, map)) {
                        used[i] = false;
                        res = true;
                        break;
                    }
                    used[i] = false;
                }
            }
            map.put(format, res);
        }
        return map.get(format);
    }
    
    public int format(boolean[] used) {
        int sum = 0;
        for (int i = 0; i< used.length; i++) {
            if (used[i]) {
                sum += (1 << (used.length - 1 - i));
            }
        }
        return sum;
    }
}