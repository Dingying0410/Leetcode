class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;
        int[] next = new int[primes.length];
        for (int i = 1; i < n; i++) {
            res[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                res[i] = Math.min(primes[j] * res[next[j]], res[i]);
            }
            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * res[next[j]] <= res[i])
                    next[j]++;
            }
        }
        return res[n - 1];
    }
}
