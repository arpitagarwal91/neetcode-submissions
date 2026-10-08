/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
        for(int i=0;i<intervals.size()-1;i++){
            Interval itv1 = intervals.get(i);
            Interval itv2 = intervals.get(i+1);
            if(itv1.end>itv2.start) return false;
        }
        return true;
    }
}
