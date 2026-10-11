class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int flight[]:flights){
            adj.computeIfAbsent(flight[0], p -> new ArrayList<>()).add(new int[]{flight[1], flight[2]}); //node, cost
        }
        int dist[] = new int[n];
        Arrays.fill(dist, (int)(1e9));
        dist[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0}); // node, cost, stops

        while(!q.isEmpty()){
            int ele[] = q.poll();
            //if(ele[2]>k) continue;
            for(int dest[]:adj.getOrDefault(ele[0], new ArrayList<>())){
                if(ele[1]+dest[1]<dist[dest[0]] && ele[2]<=k){
                    q.add(new int[]{dest[0], ele[1]+dest[1], ele[2]+1});
                    dist[dest[0]] = ele[1]+dest[1];
                }
            }
        }
        return dist[dst]==(int)(1e9) ? -1 : dist[dst];
    }
}
