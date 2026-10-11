class Solution {
    public int leastInterval(char[] tasks, int n) {
        int count[] = new int[26];
        for(char task:tasks) count[task-'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int cnt:count){
            if(cnt>0) pq.add(cnt);
        }
        Queue<int[]> q = new LinkedList<>();
        int t = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            t++;
            if(!pq.isEmpty()){
                int cnt = pq.poll()-1;
                if(cnt>0){
                    q.add(new int[]{cnt, t+n});
                }
            }
            else{
                t = q.peek()[1];
            }
            if(!q.isEmpty() && q.peek()[1]==t){
                pq.add(q.poll()[0]);
            }
        }
        return t;
    }
}
