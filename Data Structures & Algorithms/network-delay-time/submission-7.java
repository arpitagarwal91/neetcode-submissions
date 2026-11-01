class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int time[]:times){
            adj.computeIfAbsent(time[0], p -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        boolean visit[] = new boolean[n+1];
        int dist[] = new int[n+1];
        Arrays.fill(dist, (int)(1e9));
        dist[k] = 0;
        dist[0] = -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{k, 0});

        while(!q.isEmpty()){
            int ele[] = q.poll();
            for(int nei[]:adj.getOrDefault(ele[0], Collections.emptyList())){
                if(dist[nei[0]]>nei[1]+ele[1]){
                    dist[nei[0]] = nei[1]+ele[1];
                    q.add(new int[]{nei[0], dist[nei[0]]});
                }
            }
        }
        int res = Arrays.stream(dist).max().orElse(-1);
        return res==(int)(1e9) ? -1 : res;
    }
}
