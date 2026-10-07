class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int st:stones) pq.add(st);
        while(pq.size()>1){
            int st1 = pq.poll();
            int st2 = pq.poll();
            if(st1-st2>0) pq.add(st1-st2);
        }
        return pq.size()==0 ? 0 : pq.poll();
    }
}
