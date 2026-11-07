class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for(int num:nums){
            this.pq.add(num);
            if(pq.size()>k) this.pq.poll();
        }
    }
    
    public int add(int val) {
        this.pq.add(val);
        if(pq.size()>k) this.pq.poll();
        return pq.peek();
    }
}
