class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(int st:stones) pq.add(st);
        while(pq.size()>1){
            int diff = pq.poll() - pq.poll();
            if(diff>0) pq.add(diff);
        }
        return pq.size()==0 ? 0 : pq.peek();
    }
}
