class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1]>heights[i]){
                int ele[] = stack.pop();
                maxArea = Math.max(maxArea, (i-ele[0])*ele[1]);
                start = ele[0];
            }
            stack.add(new int[]{start, heights[i]});
        }

        while(!stack.isEmpty()){
            int ele[] = stack.pop();
            int area = ele[1]*(heights.length-ele[0]);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
