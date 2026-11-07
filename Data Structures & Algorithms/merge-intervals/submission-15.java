class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            if(stack.peek()[1]<intervals[i][0]){
                stack.push(intervals[i]);
            }
            else{
                int last[] = stack.pop();
                stack.push(new int[]{last[0], Math.max(last[1], intervals[i][1])});
            }
        }
        int res[][] = new int[stack.size()][2];
        int k = stack.size()-1;
        while(!stack.isEmpty()){
            res[k--] = stack.pop();
        }
        return res;
    }
}
