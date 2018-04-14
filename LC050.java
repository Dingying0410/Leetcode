class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (x == 1)
            return 1;
        if (n < 0)
            return myPow(1.0 / x, -(n + 1)) * (1.0 / x);
        double temp = myPow(x, n / 2);
        if (n % 2 != 0)
            return temp * temp * x;
        else
            return temp * temp;
    }
}