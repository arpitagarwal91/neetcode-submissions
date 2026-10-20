class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int flight[]:flights) adj.computeIfAbsent(flight[0], p -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});

        int dist[] = new int[n];
        Arrays.fill(dist, (int)(1e9));
        dist[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0}); //node, cost, stop

        while(!q.isEmpty()){
            int ele[] = q.poll();
            for(int dest[]:adj.getOrDefault(ele[0], Collections.emptyList())){
                int cost = ele[1]+dest[1];
                if(cost<dist[dest[0]] && ele[2]<=k){
                    q.add(new int[]{dest[0], cost, 1+ele[2]});
                    dist[dest[0]] = cost;
                }
            }
        }

        return dist[dst]==(int)(1e9) ? -1 : dist[dst];
    }
}
