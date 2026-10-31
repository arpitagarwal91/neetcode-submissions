class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int flight[]:flights) adj.computeIfAbsent(flight[0], p -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        //boolean visit[] = new boolean[n]; // Used this visit set unnecessarily
        int dist[] = new int[n]; //IMP: Forgot to take this in this attempt
        Arrays.fill(dist, (int)(1e9));
        Queue<int[]> q = new LinkedList<>(); // Used PQ instead of this in last attempt
        q.add(new int[]{src, 0, 0}); // node, cost, stops
        dist[src] = 0;
        while(!q.isEmpty()){
            int ele[] = q.poll();
            //visit[ele[0]] = true; // Used this visit set unnecessarily
            for(int nei[]:adj.getOrDefault(ele[0], Collections.emptyList())){
                int cost = ele[1]+nei[1];
                if(cost<dist[nei[0]] && ele[2]<=k){
                    q.add(new int[]{nei[0], cost, 1+ele[2]});
                    dist[nei[0]] = cost;
                }
            }
        }
        return dist[dst]==(int)(1e9) ? -1 : dist[dst];
    }
}
