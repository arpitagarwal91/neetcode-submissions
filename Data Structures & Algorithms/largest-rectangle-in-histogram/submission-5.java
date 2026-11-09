class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int res = 0;
        for(int i=0;i<heights.length;i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1]>=heights[i]){
                int ele[] = stack.pop();
                start = ele[0];
                int area = ele[1]*(i-start);
                res = Math.max(res, area);
            }
            stack.push(new int[]{start, heights[i]});
        }

        while(!stack.isEmpty()){
            int ele[] = stack.pop();
            int area = (heights.length - ele[0])*ele[1];
            res = Math.max(res, area);
        }
        
        return res;
    }
}
