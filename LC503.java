// Given a circular array (the next element of the last element is the first element of the array), 
// print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, 
// which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length * 2; i++) {
            int j = i % nums.length;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[j]) {
                res[stack.pop()] = nums[j];
            }
            if (i < nums.length)
                stack.push(i);
        }
        return res;
    }
}