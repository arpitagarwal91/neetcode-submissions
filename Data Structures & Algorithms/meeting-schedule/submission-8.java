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
        if(intervals.size()==0) return true;
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        int prevEnd = intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
            if(prevEnd<=intervals.get(i).start){
                prevEnd = intervals.get(i).end;
            }
            else return false;
        }
        return true;
    }
}
