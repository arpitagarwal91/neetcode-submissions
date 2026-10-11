class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int itv[] = intervals[i];
            int start = itv[0];
            int end = itv[1];
            if(end<newInterval[0]){
                ans.add(itv);
            }
            else if(newInterval[1]<start){
                ans.add(newInterval);
                for(int j=i;j<intervals.length;j++) ans.add(intervals[j]);
                int res[][] = new int[ans.size()][2];
                int p = 0;
                for(int itv1[]:ans) res[p++] = itv1;
                return res;
            }
            else {
                start = Math.min(start, newInterval[0]);
                end = Math.max(end, newInterval[1]);
                newInterval = new int[]{start, end};
            }
        }
        ans.add(newInterval);
        int res[][] = new int[ans.size()][2];
        int p = 0;
        for(int itv[]:ans) res[p++] = itv;
        return res;
    }
}
