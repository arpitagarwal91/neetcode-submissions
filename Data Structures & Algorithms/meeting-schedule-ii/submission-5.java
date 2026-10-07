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
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0] - b[0]);
        for(Interval itv:intervals){
            pq.add(new int[]{itv.start, 1});
            pq.add(new int[]{itv.end, -1});
        }
        int res = 0;
        int count = 0;
        while(!pq.isEmpty()){
            count+=pq.poll()[1];
            res = Math.max(res, count);
        }
        return res;
    }
}
