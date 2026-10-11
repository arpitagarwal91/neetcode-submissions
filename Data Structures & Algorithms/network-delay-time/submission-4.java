class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int time[]:times){
            adj.computeIfAbsent(time[0], p-> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{k, 0});
        while(!pq.isEmpty() && visit.size()<n){
            int ele[] = pq.poll();
            if(visit.contains(ele[0])) continue;
            visit.add(ele[0]);
            if(visit.size()==n) {
                return ele[1];
            }
            for(int[] nei:adj.getOrDefault(ele[0], new ArrayList<>())){
                pq.add(new int[]{nei[0], ele[1]+nei[1]});
            }
        }
        return -1;
    }
}
