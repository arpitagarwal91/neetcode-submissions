class KthLargest {
    PriorityQueue<Integer> pq;
    int k = 0;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for(int num:nums) add(num);
    }
    
    public int add(int val) {
        if(pq.size()<k) this.pq.offer(val);
        else if(val>this.pq.peek()){
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
