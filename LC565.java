class Solution {
    public int arrayNesting(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int size = set.size();
            while (set.add(nums[i])) {
                i = nums[i];
            }
            max = Math.max(max, set.size() - size);
        }
        return max;
    }
}