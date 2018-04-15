class Solution {
    //What differes from the one without duplicates is that
    //if nums[start] == nums[mid], one is on the left, and mid is on the right,
    //if we do start = mid + 1,
    //then we might skip the target which is located in the middle
    //so we only do start++ here
    public boolean search(int[] nums, int target) {
        if (nums.length == 0)
            return false;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return true;
            else if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[start] > nums[mid]) {
                if (nums[mid] < target && target <= nums[end])
                    start = mid + 1;
                else 
                    end = mid - 1;
            } else {
                start++;
            }
        }
        return nums[start] == target;
    }
}