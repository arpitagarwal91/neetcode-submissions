class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1]>heights[i]){
                int ele[] = stack.pop();
                int area = (i-ele[0])*ele[1];
                start = Math.min(start, ele[0]);
                res = Math.max(res, area);
            }
            stack.add(new int[]{start, heights[i]});
        }
        while(!stack.isEmpty()){
            int ele[] = stack.pop();
            int area = (heights.length-ele[0])*ele[1];
            res = Math.max(res, area);
        }
        return res;
    }
}
