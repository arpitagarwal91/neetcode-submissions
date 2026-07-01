public class Solution {
    public int Trap(int[] height) {
        int l=0;
        int r=height.Length-1;
        int leftMax = height[l];
        int rightMax = height[r];
        int maxArea = 0;
        while(l<r){
            if(leftMax<rightMax){
                l++;
                leftMax = Math.Max(leftMax, height[l]);
                maxArea+=(leftMax-height[l]);
            }
            else{
                r--;
                rightMax = Math.Max(rightMax, height[r]);
                maxArea+=(rightMax-height[r]);
            }
        }
        return maxArea;
    }
}
// Math.Min(leftMax, rightMax) - heights[i]