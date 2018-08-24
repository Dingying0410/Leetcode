/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 2)
            return points.length;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int max = 0;
            int overlaps = 0;
            map.clear();
            for (int j = i + 1; j < points.length; j++) {
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if (x == 0 && y == 0) {
                    overlaps++;
                    continue;
                }
                int gcd = gcd(x, y);
                x /= gcd;
                y /= gcd;
                if (map.containsKey(x)) {
                    map.get(x).put(y, map.get(x).getOrDefault(y, 0) + 1);
                } else {
                    Map<Integer, Integer> temp = new HashMap<>();
                    temp.put(y, 1);
                    map.put(x, temp);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            res = Math.max(res, max + 1 + overlaps);
        }
        return res;
    }

    public int gcd (int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
