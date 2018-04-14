class Solution {
    //Put the numbers into a list recursively using dfs
    //If the sum equals target, then put it into the result
    //start: the index to choose from
    //target: the target that the remaining numbers should sum up to
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), 0, target, candidates);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int start, int target, int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (target < 0)
            return;
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(res, list, i, target - candidates[i], candidates);
            list.remove(list.size() - 1);
        }
    }
}