class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0)
            return 0;
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[] min = new int[n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == m - 1) {
                    min[j] = triangle.get(i).get(j);
                } else {
                    min[j] = Math.min(min[j], min[j + 1]) + triangle.get(i).get(j);
                }
            }
        }
        return min[0];
    }
}