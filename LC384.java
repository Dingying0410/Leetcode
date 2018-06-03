class Solution {

    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] copy = nums.clone();
        Random r = new Random();
        for (int j = 1; j < copy.length; j++) {
            int i = r.nextInt(j + 1);
            if (i != j) {
                swap(i, j, copy);
            }
        }
        return copy;
    }

    public void swap (int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
