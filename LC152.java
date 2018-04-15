class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curMax = Integer.MAX_VALUE;
        int minSoFar = 1;
        int maxSoFar = 1;
        for (int i = 0; i < nums.length; i++) {
            curMax = Math.max(minSoFar * nums[i], Math.max(maxSoFar * nums[i], nums[i]));
            int temp = minSoFar;
            minSoFar = Math.min(maxSoFar * nums[i], Math.min(nums[i] * minSoFar, nums[i]));
            maxSoFar = Math.max(maxSoFar * nums[i], Math.max(nums[i] * temp, nums[i]));
            max = Math.max(curMax, max);
        }
        return max;
    }
}