class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<intervals.length;i++){
            if(newInterval[1]<intervals[i][0]){
                stack.push(newInterval);
                for(int j=i;j<intervals.length;j++){
                    stack.push(intervals[j]);
                }
                int res[][] = new int[stack.size()][2];
                int p = stack.size()-1;
                while(!stack.isEmpty()) res[p--] = stack.pop();
                return res;
            }
            else if(intervals[i][1]<newInterval[0]){
                stack.push(intervals[i]);
            }
            else{
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        stack.push(newInterval);
        int res[][] = new int[stack.size()][2];
        int p = stack.size()-1;
        while(!stack.isEmpty()) res[p--] = stack.pop();
        return res;
    }
}
