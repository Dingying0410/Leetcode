class Solution {
    //dp[i]: whether I can jump to index i
    //dp[i] = dp[j] && (j + nums[j] == i)
    public boolean canJump(int[] nums) {
        //2, 5, 0, 0
        int last = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= last) {
                last = i;
            }
        }
        return last == 0;
    }
}