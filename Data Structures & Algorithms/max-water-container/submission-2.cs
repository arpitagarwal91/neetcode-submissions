public class Solution {
    public int MaxArea(int[] heights) {
        int maxArea = 0;
        int l = 0;
        int r = heights.Length-1;
        while(l<r){
            int area = (r-l)*Math.Min(heights[l], heights[r]);
            maxArea = Math.Max(maxArea, area);
            if(heights[l]<heights[r]) l++;
            else r--;
        }
        return maxArea;
    }
}
