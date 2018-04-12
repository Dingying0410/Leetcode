class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        helper(res, new ArrayList<Integer>(), 0, nums);
        return new ArrayList<>(res);
    }
    
    public void helper (Set<List<Integer>> res, List<Integer> list, int start, int[] nums) {
        if (list.size() > 1) {
            res.add(new ArrayList<>(list));
        }
        for (int i = start; i < nums.length; i++) {
            if (list.size() == 0 || nums[i] >= list.get(list.size() - 1)) {
                list.add(nums[i]);
                helper(res, list, i + 1, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}