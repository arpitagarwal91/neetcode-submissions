class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int res[] = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                int idx = st.pop();
                res[idx] = i-idx; 
            }
            st.push(i);
        }
        return res;
        // 5 6 
        // 1 4 1 2 1
    }
}
