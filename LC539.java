class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> times = new ArrayList<>();
        for (int i = 0; i < timePoints.size(); i++) {
            String s = timePoints.get(i);
            int idx = s.indexOf(':');
            int h = Integer.valueOf(s.substring(0, idx));
            int m = Integer.valueOf(s.substring(idx + 1));
            times.add(h * 60 + m);
        }
        Collections.sort(times);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < times.size() - 1; i++) {
            min = Math.min(times.get(i + 1) - times.get(i), min);
        }
        min = Math.min(min, times.get(0) - times.get(times.size() - 1) + 24 * 60);
        return min;
    }
}