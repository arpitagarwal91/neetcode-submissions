public class Solution {
    public int[][] Merge(int[][] intervals) {
        Array.Sort(intervals, (a,b)=> a[0]-b[0]);
        var res = new List<int[]>();
        res.Add(intervals[0]);
        for(int i=0;i<intervals.Length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int lastEnd = res[res.Count-1][1];
            if(start<=lastEnd){
                res[res.Count-1][1] = Math.Max(end,lastEnd);
            }
            else {
                res.Add(intervals[i]);
            }
        }
        return res.ToArray();
    }
}
