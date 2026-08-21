class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        Stack<int[]> st = new Stack<>();
        for(int itv[]:intervals){
            if(!st.isEmpty() && st.peek()[1]<itv[0]) {
                st.add(itv);
                continue;
            }
            else if(st.isEmpty()) {
                st.add(itv);
                continue;
            }
            int ele[] = st.pop();
            int start = ele[0];
            int end = Math.max(ele[1], itv[1]);
            st.add(new int[]{start, end});
        }
        int res[][] = new int[st.size()][2];
        int p = st.size()-1;
        while(!st.isEmpty()){
            res[p--] = st.pop();
        }
        return res;

    }
}
