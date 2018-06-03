class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        String[] strs = input.split("\n");
        int max = 0;
        for (String str : strs) {
            int level = str.lastIndexOf('\t') + 1;
            while (stack.size() > level)
                stack.pop();
            int curLen = str.length() - level + 1; //add the length for /
            if (str.indexOf('.') > 0) {
                max = Math.max(curLen + (stack.isEmpty()? 0 : stack.peek()) - 1, max);
            }
            stack.push((stack.isEmpty()? 0 : stack.peek()) + curLen);
        }
        return max;
    }
}
