class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall.size() == 0 || wall.get(0).size() == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < wall.size(); i++) {
            int local = 0;
            for (int j = 0; j < wall.get(i).size(); j++) {
                local += wall.get(i).get(j);
                if (j != wall.get(i).size() - 1) {
                    map.put(local, map.getOrDefault(local, 0) + 1);
                    max = Math.max(map.get(local), max);
                }
            }
        }
        return wall.size() - max;
    }
}