class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int arr[][] = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a,b)-> b[0] - a[0]);
        Stack<Double> stack = new Stack<>();
        for(int i=0;i<n;i++){
            double time = (((double)target-arr[i][0])/(double)arr[i][1]);
            if(!stack.isEmpty() && stack.peek()>=time) continue;
            stack.push(time);
        }
        return stack.size();
    }
}
