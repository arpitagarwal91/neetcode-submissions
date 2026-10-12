class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        Stack<int[]> stack = new Stack<>();
        int prev = -1;
        for(int i=0;i<intervals.length;i++){
           if(!stack.isEmpty()) prev = stack.peek()[1];
           int start1 = intervals[i][0];
           int end1 = intervals[i][1];
           if(prev<start1){
            stack.add(intervals[i]);
           }
           else{
            int ele[] = stack.pop();
            int prevStart = ele[0];
            int prevEnd = ele[1];
            stack.add(new int[]{prevStart, Math.max(end1,prevEnd)});
           }
        }
        int res[][] = new int[stack.size()][2];
        int p = res.length;
        while(!stack.isEmpty()) res[--p] = stack.pop();
        return res;
    }
}
