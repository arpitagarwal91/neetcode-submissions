class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[2]-a[2]);
        for(int pt[]:points){
            pq.add(new int[] {pt[0], pt[1], (pt[0]*pt[0])+(pt[1]*pt[1])});
            if(pq.size()>k) pq.poll();
        }
        int res[][] = new int[k][2];
        while(!pq.isEmpty()){
            res[--k] = new int[]{pq.peek()[0], pq.poll()[1]};
        }
        return res;
    }
}
