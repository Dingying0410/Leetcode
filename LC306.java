import java.math.BigInteger;

class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length() - 2; i++) {
            if (i > 1 && num.charAt(0) == '0')
                break;
            for (int j = i + 1; j <= num.length() - 1; j++) {
                if (j - i > 1 && num.charAt(i) == '0')
                    break;
                BigInteger num1 = new BigInteger(num.substring(0, i));
                BigInteger num2 = new BigInteger(num.substring(i, j));
                if (valid(num1, num2, num, j))
                    return true;
            }
        }
        return false;
    }

    public boolean valid (BigInteger num1, BigInteger num2, String num, int start) {
        if (start == num.length())
            return true;
        BigInteger num3 = num1.add(num2);
        if (!num.startsWith(num3.toString(), start))
            return false;
        return valid(num2, num3, num, start + num3.toString().length());
    }
}
