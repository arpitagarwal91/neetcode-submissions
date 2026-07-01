public class Solution {
    public int[] DailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<int[]>();
        int[] res = new int[temperatures.Length];
        for(int i=0;i<temperatures.Length;i++){
            while(stack.Count>0 && temperatures[i]>stack.Peek()[0]){
                int[] ele = stack.Pop();
                res[ele[1]] = i - ele[1];
            }
            stack.Push(new int[]{temperatures[i], i});
        }
        return res;
    }
}
