class Solution {
    public int findNthDigit(int n) {
        int numOfDigits = 1;
        long remain = 9;
        long base = 1;
        //the number of digits of the number, 1, 10, 100...
        while (n > remain * numOfDigits) {
            n -= remain * numOfDigits;
            remain *= 10;
            numOfDigits++;
            base *= 10;
        }
        //What is the number
        long num = base + (n - 1) / numOfDigits;
        //Which digit of the number
        char c = String.valueOf(num).charAt((n - 1) % numOfDigits);
        return c - '0';
    }
}