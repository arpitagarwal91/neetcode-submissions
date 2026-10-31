class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int nums[][] = new int[n][2];
        for(int i=0;i<n;i++){
            nums[i][0] = target-position[i];
            nums[i][1] = speed[i];
        }
        Arrays.sort(nums, (a,b) -> a[0]-b[0]);
        Stack<Double> time = new Stack<>();
        for(int i=0;i<n;i++){
            double timeTaken = ((double)nums[i][0]/nums[i][1]);
            if(!time.isEmpty() && time.peek()>=timeTaken){
                continue;
            }
            time.push(timeTaken);
        }
        return time.size();
    }
}
