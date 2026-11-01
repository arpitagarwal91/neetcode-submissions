class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> count = new HashMap<>();
        for(char c:tasks) count.put(c, count.getOrDefault(c, 0)+1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b.compareTo(a));
        for(char c:count.keySet()) pq.add(count.get(c));

        Queue<int[]> q = new LinkedList<>();
        int t = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            t++;
            if(!pq.isEmpty()){
                int cnt = pq.poll()-1;
                if(cnt>0) q.add(new int[]{cnt, t+n});
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
