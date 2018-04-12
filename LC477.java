class Solution {
    public int totalHammingDistance(int[] nums) {
        int count = 0;
        for (int i = 0; i < 31; i++) {
            int one = 0, zero = 0;
            for (int num : nums) {
                if ((num & (1 << i)) == 0)
                    zero++;
                else 
                    one++;
            }
            count += zero * one;
        }
        return count;
    }
    
}