class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int arr[][] = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = target - position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a,b) -> a[0]-b[0]);
        Stack<Double> timeStack = new Stack<>();
        for(int i=0;i<n;i++){
            double time = (double)arr[i][0]/arr[i][1];
            if(!timeStack.isEmpty() && timeStack.peek()>=time) continue;
            timeStack.push(time);
        }
        return timeStack.size();
    }
}
