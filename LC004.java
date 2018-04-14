class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        if ((len1 + len2) % 2 == 0) {
            return (helper(0, nums1, 0, nums2, (len1 + len2 + 2) / 2) + helper(0, nums1, 0, nums2, (len1 + len2 + 1) / 2)) / 2;
        } else {
            return helper(0, nums1, 0, nums2, (len1 + len2 + 1) / 2);
        }
    }
    
    public double helper (int start1, int[] nums1, int start2, int[] nums2, int k) {
        if (start1 >= nums1.length)
            return nums2[start2 + k - 1];
        if (start2 >= nums2.length)
            return nums1[start1 + k - 1];
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        } 
        int k1 = k / 2;
        int mid1 = start1 + k1 - 1 >= nums1.length? Integer.MAX_VALUE : nums1[start1 + k1 - 1];
        int mid2 = start2 + k1 - 1 >= nums2.length? Integer.MAX_VALUE : nums2[start2 + k1 - 1];
        if (mid1 < mid2) {
            return helper(start1 + k1, nums1, start2, nums2, k - k1);
        } else {
            return helper(start1, nums1, start2 + k1, nums2, k - k1);
        }
    }
}