class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int t[]:times){
            adj.computeIfAbsent(t[0], p -> new ArrayList<>()).add(new int[]{t[1], t[2]});
        }
        int dist[] = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        dist[0] = -1;
        Queue<int[]> q = new LinkedList<>(); //node, dist
        q.add(new int[]{k, 0});
        while(!q.isEmpty()){
            int ele[] = q.poll();
            int node = ele[0];
            int d = ele[1];
            for(int nei[]:adj.getOrDefault(node, Collections.emptyList())){
                if(dist[nei[0]]>d+nei[1]){
                    dist[nei[0]] = d+nei[1];
                    q.add(new int[]{nei[0], d+nei[1]});
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i=0;i<n+1;i++) res = Math.max(res, dist[i]);
        return res==Integer.MAX_VALUE ? dist[0] : res;
    }
}
