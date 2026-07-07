class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int pair[][] = new int[n][2];
        for(int i=0;i<n;i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a,b)->b[0]-a[0]);
        Stack<Double> stack = new Stack<>();
        for(int i=0;i<n;i++){
            stack.add((double)(target-pair[i][0])/pair[i][1]);
            while(stack.size()>1 && (stack.peek()<=stack.get(stack.size()-2))){
                stack.pop();
            }
        }
        return stack.size();
    }
}
