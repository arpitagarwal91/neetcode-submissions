class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>((a,b)->a-b);
        this.maxHeap = new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        this.maxHeap.add(num);
        if(this.maxHeap.size()-this.minHeap.size()>1 || (!this.minHeap.isEmpty() && this.maxHeap.peek()>this.minHeap.peek())){
            this.minHeap.add(this.maxHeap.poll());
        }
        if(this.minHeap.size()-this.maxHeap.size()>1) this.maxHeap.add(this.minHeap.poll());
    }
    
    public double findMedian() {
        if(this.minHeap.size()>this.maxHeap.size()) return (double)this.minHeap.peek();
        else if(this.maxHeap.size()>this.minHeap.size()) return (double)this.maxHeap.peek();
        return ((double)(this.minHeap.peek()+this.maxHeap.peek()))/2;
    }
}
