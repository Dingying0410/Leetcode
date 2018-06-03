class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= Math.min(9, n); i++) {
            helper(res, i, n);
        }
        return res;
    }

    public void helper(List<Integer> list, int cur, int max) {
        if (cur > max)
            return;
        list.add(cur);
        for (int i = 0; i <= 9; i++) {
            helper(list, cur * 10 + i, max);
        }
    }
}
