class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = {2, 3, 5};
        int[] next = new int[3];
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = Math.min(nums[0] * res[next[0]], Math.min(nums[1] * res[next[1]], nums[2] * res[next[2]]));
            for (int j = 0; j < nums.length; j++) {
                while (nums[j] * res[next[j]] <= res[i])
                    next[j]++;
            }
        }
        return res[n - 1];
    }
}
