class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int res[] = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()[0]]<temperatures[i]){
                res[stack.peek()[0]] = i-stack.pop()[0];
            }
            stack.push(new int[]{i});
        }
        return res;
    }
}
