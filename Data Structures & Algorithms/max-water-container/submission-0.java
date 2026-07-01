class Solution {
    public int maxArea(int[] heights) {
        int area = 0;
        int start = 0;
        int end = heights.length - 1;
        while(start<end){
            area = Math.max(area, (end-start)*Math.min(heights[start],heights[end]));
            if(heights[start]<heights[end]){
                start++;
            }
            else{
                end--;
            }
        }
        return area;
    }
}
