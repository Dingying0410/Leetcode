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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int newStart = newInterval.start;
        int newEnd = newInterval.end;
        int start = newStart, end = newEnd;
        //newStart > end
        int i = 0;
        while (i < intervals.size() && newStart > intervals.get(i).end) {
            res.add(intervals.get(i));
            i++;
        }
        //merge
        while (i < intervals.size() && intervals.get(i).start <= newEnd) {
            start = Math.min(start, intervals.get(i).start);
            end = Math.max(end, intervals.get(i).end);
            i++;
        }
        res.add(new Interval(start, end));
        //start > newEnd
        while (i < intervals.size()) {
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }
}