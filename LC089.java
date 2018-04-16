class Solution {
    public List<Integer> grayCode(int n) {
        //n = 0: 0
        //n = 1: 0, 1
        //n = 2: 00, 01, 10, 11
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                res.add(res.get(j) | (1 << i));
            }
        }
        return res;
    }
}