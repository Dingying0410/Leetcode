class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return new ArrayList<>(Arrays.asList(0));
        Map<Integer, Set<Integer>> next = new HashMap<>();
        for (int i = 0; i < n; i++) {
            next.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            next.get(edge[0]).add(edge[1]);
            next.get(edge[1]).add(edge[0]);
        }
        Set<Integer> leaves = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (next.get(i).size() == 1)
                leaves.add(i);
        }
        while (n > 2) {
            n -= leaves.size();
            Set<Integer> temp = new HashSet<>();
            for (int leaf : leaves) {
                for (int nextNode : next.get(leaf)) {
                    next.get(nextNode).remove(leaf);
                    if (next.get(nextNode).size() == 1) {
                        temp.add(nextNode);
                    }
                }
            }
            leaves = temp;
        }
        return new ArrayList<>(leaves);
    }
}
