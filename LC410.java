class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums.length == 0 || nums.length < m)
            return 0;
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            sum += nums[i];
        }
        int left = max, right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canBeSplitted(mid, m, nums)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    public boolean canBeSplitted (int sum, int m, int[] nums) {
        int curSum = 0;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum > sum) {
                count++;
                curSum = nums[i];
            }
            if (count > m)
                return false;
        }
        return true;
    }
}