class Solution {
    public int removeDuplicates(int[] nums) {
        //count, len
        int count = 0, len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                count = 1;
            } else {
                if (nums[i] == nums[i - 1]) {
                    count++;
                } else {
                    count = 1;
                }
            }
            if (count <= 2) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}