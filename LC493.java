class Solution {
    int res = 0;
    public int reversePairs(int[] nums) {
        mergeSort(0, nums.length - 1, nums);
        return res;
    }
    
    public void mergeSort (int left, int right, int[] nums) {
        if (left >= right)
            return;
        int mid = left + (right - left) / 2;
        mergeSort(left, mid, nums);
        mergeSort(mid + 1, right, nums);
        int count = 0;
        for (int l = left, r = mid + 1; l <= mid;) {
            if (r > right || (long)nums[l] <= (long)nums[r] * 2) {
                res += count;
                l++;
            } else {
                r++;
                count++;
            }
        }
        Arrays.sort(nums, left, right + 1);
    }
}