class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b-a);
        for(int stone: stones) pq.add(stone);
        while(pq.size()>1){
            pq.offer(Math.abs(pq.poll()-pq.poll()));
        }
        return pq.size()>0?pq.poll():0;
    }
}
