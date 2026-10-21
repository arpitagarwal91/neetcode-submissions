class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        Stack<int[]> stack = new Stack<>();
        for(int itv[]:intervals){
            if(!stack.isEmpty()){
                if(stack.peek()[1]<itv[0]){
                    stack.push(itv);
                }
                else{
                    int last[] = stack.pop();
                    stack.push(new int[]{last[0], Math.max(last[1], itv[1])});
                }
            }
            else{
                stack.push(itv);
            }
        }
        List<int[]> ls = stack.stream().collect(Collectors.toList());
        Collections.reverse(ls);
        int res[][] = new int[ls.size()][2];
        int p = 0;
        while(p<ls.size()) {
            res[p] = ls.get(p++);
        }
        return res;
    }
}
