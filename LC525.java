class Solution {
    public int findMaxLength(int[] nums) {
        //[1, 0, 1, ,1, 1, 0, 0, 1, 0]
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0? -1 : 1;
            if (map.containsKey(sum)) {
                max = Math.max(i - map.get(sum), max);
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}