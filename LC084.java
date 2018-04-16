class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length? 0 : heights[i];
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                max = Math.max(heights[top] * (stack.isEmpty()? i : i - stack.peek() - 1), max);
                i--;
            }
        }
        return max;
    }
}