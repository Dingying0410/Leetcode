class Solution {
    public int trailingZeroes(int n) {
        //multiples of 5, multiples of 25, ...
        int res = 0;
        for (long i = 5; i <= n; i *= 5) {
            res += n / i;
        }
        return res;
    }
}