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
        Collections.sort(intervals, (a,b) -> a.start==b.start ? a.end-b.end : a.start-b.start);
        Stack<Interval> st = new Stack<>();
        st.push(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            if(st.peek().end<=intervals.get(i).start) st.push(intervals.get(i));
            else return false;
        }
        return true;
    }
}
