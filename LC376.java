class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int start = 0;
        while (start < nums.length - 1 && nums[start] == nums[start + 1])
            start++;
        if (start == nums.length - 1)
            return 1;
        boolean searchLarger = nums[start] > nums[start + 1];
        int max = 2;
        int curMin = Math.min(nums[start], nums[start + 1]);
        int curMax = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < nums.length; i++) {
            if (searchLarger) {
                if (nums[i] > curMin) {
                    max++;
                    curMax = nums[i];
                    searchLarger = false;
                } else if (nums[i] < curMin) {
                    curMin = nums[i];
                }

            } else {
                if (nums[i] < curMax) {
                    max++;
                    curMin = nums[i];
                    searchLarger = true;
                } else if (nums[i] > curMax) {
                    curMax = nums[i];
                }

            }
        }
        return max;
    }
}
