class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<int[]>();
        for(int i=0;i<heights.length;i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1]>heights[i]){
                int ele[] = stack.pop();
                start = ele[0];
                maxArea = Math.max(maxArea, ele[1]*(i-ele[0]));
            }
            stack.push(new int[]{start, heights[i]});
        }

        while(!stack.isEmpty()){
            int ele[] = stack.pop();
            maxArea = Math.max(maxArea, ele[1]*(heights.length - ele[0]));
        }
        return maxArea;
    }
}
