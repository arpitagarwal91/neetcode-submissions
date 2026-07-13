class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> count = new HashMap<>();
        for(char task:tasks) count.put(task, count.getOrDefault(task, 0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int val:count.values()) pq.add(val);
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int ele = pq.poll()-1;
                if(ele>0){ //Forgot to add this check
                    q.add(new int[]{ele, time+n});
                }
            }
            else{
                time = q.peek()[1];
            }
            if(!q.isEmpty() && q.peek()[1]==time) pq.add(q.poll()[0]);
        }
        return time;
    }
}
