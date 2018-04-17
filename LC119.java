class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            int size = res.size();
            for (int j = size; j >= 0; j--) {
                if (j == size) {
                    res.add(1);
                } else {
                    res.set(j, res.get(j) + (j > 0 ? res.get(j - 1) : 0));
                }
            }
        }
        return res;
    }
}