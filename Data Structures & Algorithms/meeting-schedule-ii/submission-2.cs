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

public class Solution {
    public int MinMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.Count];
        int[] end = new int[intervals.Count];
        for(int i=0;i<intervals.Count;i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Array.Sort(start);
        Array.Sort(end);
        int res = 0;
        int count = 0;
        int s1 = 0, e1 = 0;
        while(s1<intervals.Count){
            if(start[s1]<end[e1]){
                count++;
                s1++;
            }
            else{
                count--;
                e1++;
            }
            res = Math.Max(res, count);
        }
        return res;
    }
}
