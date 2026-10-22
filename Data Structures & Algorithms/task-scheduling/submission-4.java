class Solution {
    public int leastInterval(char[] tasks, int n) {
        Queue<int[]> q = new LinkedList<>();
        Map<Character, Integer> count = new HashMap<>();
        for(char t:tasks){
            count.put(t, count.getOrDefault(t, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        pq.addAll(count.values());
        System.out.println(pq.peek());
        int t = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            t++;
            if(!pq.isEmpty()) {
                int cnt = pq.poll()-1;
                if(cnt>0) q.add(new int[]{t+n, cnt});
            }
            else{
                t = q.peek()[0];
            }
            if(!q.isEmpty() && q.peek()[0]==t){
                pq.add(q.poll()[1]);
            }
        }
        return t;
    }
}
