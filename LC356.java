class Solution {
    public boolean isReflected(int[][] points) {
        if (points.length == 0)
            return true;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            if (!map.containsKey(y)) {
                map.put(y, new HashSet<>());
            }
            map.get(y).add(x);
            min = Math.min(x, min);
            max = Math.max(x, max);
        }
        //2 * the y coordinate of the reflection line
        int sum = min + max;
        for (int key : map.keySet()) {
            Set<Integer> set = map.get(key);
            for (int x : set) {
                if (!set.contains(sum - x))
                    return false;
            }
        }
        return true;
    }
}
