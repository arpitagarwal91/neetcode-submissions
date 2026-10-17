class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[2]-a[2]);
        for(int point[]:points){
            pq.add(new int[]{point[0], point[1], point[0]*point[0] + point[1]*point[1]});
            if(pq.size()>k) pq.poll();
        }
        int res[][] = new int[pq.size()][2];
        int p = 0;
        while(!pq.isEmpty()){
            res[p][0] = pq.peek()[0];
            res[p++][1] = pq.poll()[1];
        }
        return res;
    }
}
