class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int sum = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                sum += Math.max(leftMax - height[left], 0); 
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                sum += Math.max(rightMax - height[right], 0);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return sum;
    }
}