class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //If a % b = 0, then a is divisible by all the numbers before b
        //dp[i]: the longest length of numbers divisible by nums[i]
        //last[i]: the last number divisible by nums[i]
        //[1, 3, 9, 12]
        int n = nums.length;
        int[] dp = new int[n];
        int[] last = new int[n];
        Arrays.fill(last, -1);
        int maxDivisible = -1;
        Arrays.sort(nums);
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        last[i] = j;
                    }
                }
            }
            if (maxLen < dp[i]) {
                maxLen = dp[i];
                maxDivisible = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (maxDivisible != -1) {
            res.add(0, nums[maxDivisible]);
            maxDivisible = last[maxDivisible];
        }
        return res;
    }
}
