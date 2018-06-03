class Solution {
    int mod = 1337;

    public int superPow(int a, int[] b) {
        a %= mod;
        return superPow(a, b, b.length - 1);
    }

    public int superPow(int a, int[] b, int end) {
        if (end < 0)
            return 1;
        int temp = superPow(a, b, end - 1);
        int product = 1;
        return (pow(temp, 10)) * (pow(a, b[end])) % mod;
    }

    public int pow(int x, int y) {
        if (y == 0)
            return 1;
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        int temp = pow(x, y / 2) % mod;
        int temp_2 = (temp * temp) % mod;
        return y % 2 == 0? temp_2 : (temp_2 * x) % mod;
    }
}
