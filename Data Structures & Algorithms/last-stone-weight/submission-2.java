class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b-a);
        for(int stone:stones){
            pq.add(stone);
        }
        while(pq.size()>=2){
            int st1 = pq.poll();
            int st2 = pq.poll();
            if(st1 > st2){
                pq.add(st1-st2);
            }
        }

        return pq.size()>0 ? pq.poll() : 0;
    }
}
