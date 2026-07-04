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
    public int minMeetingRooms(List<Interval> intervals) {
        int res = 0;
        int p = 0;
        int start[] = new int[intervals.size()];
        int end[] = new int[intervals.size()];
        int cnt = 0;
        for(Interval iv:intervals){
            start[p] = iv.start;
            end[p++] = iv.end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s1 = 0, e1 = 0;
        while(s1<start.length){
            if(start[s1]<end[e1]){
                cnt++;
                s1++;
            }
            else{
                cnt--;
                e1++;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
