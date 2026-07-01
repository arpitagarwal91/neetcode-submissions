class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int maxArea = 0;
        while(left<right){
            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                maxArea+=(leftMax - height[left]);
            }
            else if(leftMax >= rightMax){
                right--;
                rightMax = Math.max(rightMax, height[right]);
                maxArea+=(rightMax - height[right]);
            }
        }
        return maxArea;
    }
}
