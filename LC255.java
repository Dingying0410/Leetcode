class Solution {

    //O(1) space
    public boolean verifyPreorder(int[] preorder) {
        int[] stack = new int[preorder.length];
        int top = 0;
        int low = Integer.MIN_VALUE;
        for (int pre : preorder) {
            if (pre < low) 
                return false;
            while (top > 0 && stack[top - 1] < pre) {
                low = stack[top - 1];
                top--;
            }
            stack[top++] = pre;
        }
        return true;
    }

    //O(n) space
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int low = Integer.MIN_VALUE;
        for (int pre : preorder) {
            if (pre < low) 
                return false;
            while (!stack.isEmpty() && pre > stack.peek())
                low = stack.pop();
            stack.push(pre);
        }
        return true;
    }
}