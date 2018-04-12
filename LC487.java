class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int zero = 0, left = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) 
                zero++;
            while (zero > 1) {
                if (nums[left++] == 0)
                    zero--;
            }
            max = Math.max(i - left + 1, max);
        }
        return max;
    }
}