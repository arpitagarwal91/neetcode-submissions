class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[0]>heights[i]){
                int h = stack.peek()[0];
                start = stack.pop()[1];
                int area = (i-start)*h;
                maxArea = Math.max(maxArea, area);
            }
            stack.add(new int[]{heights[i], start});
        }

        while(!stack.isEmpty()){
            int area = stack.peek()[0]*(heights.length-stack.peek()[1]);
            stack.pop();
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
