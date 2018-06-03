class Solution {
    public String decodeString(String s) {
        String cur = "";
        int num = 0;
        Stack<Integer> nums = new Stack<>();
        Stack<String> strs = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                nums.push(num);
                strs.push(cur);
                num = 0;
                cur = "";
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int j = i;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    num = num * 10 + s.charAt(j) - '0';
                    j++;
                }
                i = j - 1;
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(strs.pop());
                int count = nums.pop();
                for (int k = 0; k < count; k++) {
                    sb.append(cur);
                }
                cur = sb.toString();
            } else {
                cur += s.charAt(i);
            }
        }
        return cur;
    }
}
