class Solution {
    public int divide(int dividend, int divisor) {
        long dvd = Math.abs((long)dividend);
        long div = Math.abs((long)divisor);
        if (div == 0)
            return dividend > 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        if (dvd == 0)
            return 0;
        boolean sign = dividend > 0 ^ divisor > 0;
        
        long res = divide(dvd, div);
        if (res >= Integer.MAX_VALUE)
            return sign? Integer.MIN_VALUE : Integer.MAX_VALUE;
        return sign? -(int)res : (int)res;
    }
    
    public long divide (long dividend, long divisor) {
        if (dividend < divisor)
            return 0;
        long sum = divisor;
        long multiple = 1;
        //return the largest multiple such that multiple * divisor <= dividend
        //multiple changes from 1, 2, ...
        while (sum + sum <= dividend) {
            sum += sum;
            multiple <<= 1;
        }
        return multiple + divide(dividend - multiple * divisor, divisor);
    }
}