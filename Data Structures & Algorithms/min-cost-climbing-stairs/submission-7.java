class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = 0;
        for(int num:cost){
            int c = num + Math.min(a, b);
            a = b;
            b = c;
        }
        return Math.min(a, b);
    }
}
