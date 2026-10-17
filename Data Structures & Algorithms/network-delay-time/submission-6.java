class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Set<Integer> visit = new HashSet<>();
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int t[]:times){
            adj.computeIfAbsent(t[0], p -> new ArrayList<>()).add(new int[]{t[1], t[2]});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        q.add(new int[]{k, 0});
        
        while(!q.isEmpty() && visit.size()<n){
            int ele[] = q.poll();
            int node = ele[0];
            int tval = ele[1];
            if(visit.contains(node)) continue;
            visit.add(node);
            if(visit.size()==n) return tval;
            for(int nei[]:adj.getOrDefault(node, Collections.emptyList())){
                q.add(new int[]{nei[0], tval+nei[1]});
            }
        }

        return -1;
    }
}
