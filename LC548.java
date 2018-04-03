class Solution {
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (long)nums[i - 1];
        }
        
        for (int j = 3; j <= n - 4; j++) {
            Set<Long> equals = new HashSet<>();
            for (int i = 1; i + 1 < j; i++) {
                if (sum[i] == sum[j] - sum[i + 1]) {
                    equals.add(sum[i]);
                }
            }
            for (int k = j + 2; k < n - 1; k++) {
                if (sum[n] - sum[k + 1] == sum[k] - sum[j + 1] && equals.contains(sum[n] - sum[k + 1])) {
                    System.out.println(sum[n] - sum[k + 1]);
                    return true;
                }
            }
        }
        return false;
    }
}