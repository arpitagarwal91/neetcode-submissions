class Solution {
    public int[][] merge(int[][] intervals) {
        Stack<int[]> stack = new Stack<>();
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        for(int interval[]:intervals){
            if(stack.isEmpty()) {
                stack.add(interval);
                continue;
            }
            else{
                int prevEnd = stack.peek()[1];
                if(prevEnd>=interval[0]){
                    int[] prev = stack.pop();
                    int start = Math.min(prev[0], interval[0]);
                    int end = Math.max(prevEnd, interval[1]);
                    stack.add(new int[]{start, end});
                }
                else stack.add(interval);
            }
        }
        int res[][] = new int[stack.size()][2];
        int p = stack.size()-1;
        while(!stack.isEmpty()){
            res[p--] = stack.pop();
        }
        return res;
    }
}
