/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        //sort the intervals by starting point 
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0)
            return res;
        Collections.sort(intervals, (a, b) -> (a.start - b.start));
        //merge: if start > preEnd, then insert, else update preEnd
        int end = intervals.get(0).end;
        int start = intervals.get(0).start;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > end) {
                res.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = Math.max(end, intervals.get(i).end);
            } else {
                end = Math.max(end, intervals.get(i).end);
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}