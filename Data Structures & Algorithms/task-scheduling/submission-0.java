class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> count = new HashMap();
        for(char c:tasks) count.put(c,count.getOrDefault(c,0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->b-a);
        for(int i:count.values()) pq.add(i);
        Queue<int[]> q = new LinkedList();
        int time = 0;
        while(pq.size()>0 || q.size()>0){
            time++;
            if(pq.size()==0) time = q.peek()[1];
            else {
                int process = pq.poll();
                process--;
                if(process>0){
                    q.add(new int[]{process,time+n});
                }
            }
            if(q.size()>0 && q.peek()[1]==time){
                pq.add(q.poll()[0]);
            }
        }
        return time;
    }
}
