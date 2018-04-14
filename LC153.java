class Solution {
    //the start can only move to right, and end can only move to left
    //so if nums[start] < nums[end], then nums[start] is the result
    //if (nums[start] <= nums[mid]) discard the left part, and make mid = start + 1
    //...
    //Time: O(log n)
    public int findMin(int[] nums) {
        if (nums.length == 0)
            return -1;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] < nums[end])
                return nums[start];
            int mid = start + (end - start) / 2;
            if (nums[start] <= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}