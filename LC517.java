class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int[] sum = new int [n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + machines[i - 1];
        }
        if (sum[n] % n != 0)
            return -1;
        int avg = sum[n] / n;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int l = avg * i - sum[i];
            int r = avg * (n - 1 - i) - (sum[n] - sum[i] - machines[i]);
            if (l > 0 && r > 0) {
                //both sides want more clothes
                res = Math.max(l + r, res);
            } else {
                res = Math.max(Math.max(Math.abs(l), Math.abs(r)), res);
            }
        }
        return res;
    }
}