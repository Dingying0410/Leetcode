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

    //Version 2: use array as the stack, time complexity improved because using the stack might be time consuming
    //Conrner case: "10", k = 2, "9", k = 1
    //Time: O(n), Space: O(n)
    public String removeKdigits2(String num, int k) {
        char[] stk = new char[num.length()];
        int top = 0;
        int count = num.length() - k;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (top > 0 && stk[top - 1] > c && k > 0) {
                top--;
                k--;
            }
            stk[top++] = c;
        }
        int idx = 0;
        while (idx < count && stk[idx] == '0')
            idx++;
        return idx == count? "0" : new String(stk, idx, count - idx);
    }
}