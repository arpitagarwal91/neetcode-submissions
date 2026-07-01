public class Solution {
    public int[][] KClosest(int[][] points, int k) {
        PriorityQueue<int[], int> pq = new();
        foreach(int []point in points){
            int dist = (point[0]*point[0])+(point[1]*point[1]);
            pq.Enqueue(new int[]{dist, point[0], point[1] }, dist);
        }

        int[][] res = new int[k][];
        for(int i=0;i<k;i++){
            int[] point = pq.Dequeue();
            res[i] = new int[] { point[1], point[2]};
        }

        return res;
    }
}
