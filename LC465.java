class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] transaction : transactions) {
            map.put(transaction[0], map.getOrDefault(transaction[0], 0) + transaction[2]);
            map.put(transaction[1], map.getOrDefault(transaction[1], 0) - transaction[2]);
        }
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) != 0) {
                list.add(map.get(key));
            }
        }
        return dfs(0, list);
    }
    
    public int dfs (int start, List<Integer> list) {
        while (start < list.size() && list.get(start) == 0) {
            start++;
        }
        if (start == list.size())
            return 0;
        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < list.size(); i++) {
            if (list.get(i) * list.get(start) < 0) {
                list.set(i, list.get(i) + list.get(start));
                min = Math.min(min, 1 + dfs(start + 1, list));
                list.set(i, list.get(i) - list.get(start));
            }
        }
        return min;
    }
}