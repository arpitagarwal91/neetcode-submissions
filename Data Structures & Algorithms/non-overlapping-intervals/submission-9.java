class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]); //Forgot to Sort by end in last attempt.
        int count = 0;
        int prevEnd = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(prevEnd<=intervals[i][0]){
                prevEnd = intervals[i][1];
            }
            else count++;
        }
        return count;
    }
}
