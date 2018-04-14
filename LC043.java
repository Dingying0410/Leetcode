class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0)
            return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        //use an array to record the products for each bit
        long[] res = new long[len1 + len2 - 1];
        for (int i = num2.length() - 1; i >= 0; i--) {
            int a = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int b = num1.charAt(j) - '0';
                res[i + j] += a * b;
            }
        }
        //traverse the array from right to left, append carry bit to the previous bit
        //append mod to the result
        String num = "";
        for (int i = res.length - 1; i >= 0; i--) {
            if (i == 0)
                num = res[i] + num;
            else {
                res[i - 1] += res[i] / 10;
                num = (res[i] % 10) + num;
            }
        }
        //remove leading zeros
        int i = 0;
        for (;i < num.length() && num.charAt(i) == '0'; i++);
        return i == num.length()? "0" : num.substring(i);
    }
}