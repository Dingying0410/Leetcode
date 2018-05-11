class Solution {
    String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen" ,"Seventeen" ,"Eighteen", "Nineteen"};
    String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        String res = "";
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0)
                res = helper(num % 1000) + " " + THOUSANDS[i] + res;
            i++;
            num /= 1000;
        }
        return res.trim()
;    }

    public String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return " " + LESS_THAN_TWENTY[num];
        else if (num < 100)
            return " " + TENS[num / 10] + helper(num % 10);
        else
            return " " + LESS_THAN_TWENTY[num / 100] + " " + "Hundred" + helper(num % 100);
    }
}
