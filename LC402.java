class Solution {
    //Corner case: 10 k = 2, 2235, k = 3
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<Integer>();
        int len = num.length() - k;
        for (int i = 0; i < num.length(); i++) {
            int cur = num.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peek() > cur && k > 0) {
                k--;
                stack.pop();
            }
            stack.push(cur);
        }
        String res = "";
        while (!stack.isEmpty())
            res = stack.pop() + res;
        int i = 0;
        while (i < res.length() - 1 && res.charAt(i) == '0')
            i++;
        res = res.substring(i, i + len > res.length()? res.length() : i + len);
        return res.length() == 0? "0" : res;
    }
}