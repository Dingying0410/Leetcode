class Solution {
    //Time: O(log n)
    //Draw a graph to represent the rotated sorted array
    //Relationship between nums[start], nums[mid], target
    //On the left: nums[start] <= nums[mid]
    //On the right: nums[start] > nums[mid]
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        if (nums[start] == target) 
            return start;
        return -1;
    }
}