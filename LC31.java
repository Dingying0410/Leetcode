class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        for (; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                int j = nums.length - 1;
                while (j > i - 1) {
                    if (nums[j] > nums[i - 1]) {
                        swap(i - 1, j, nums);
                        break;
                    } else {
                        j--;
                    }
                }
                reverse(i, nums.length - 1, nums);
                break;
            }
        }
        if (i == 0)
            reverse(0, nums.length - 1, nums);
    }
    
    public void reverse(int i, int j, int[] nums) {
        while (i < j) {
            swap(i++, j--, nums);
        }
    }
    
    public void swap (int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}