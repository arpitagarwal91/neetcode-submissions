class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue();
        this.maxHeap = new PriorityQueue<>((a,b)-> b-a);
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        if(maxHeap.size() - minHeap.size() > 1 || (minHeap.size()>0 && maxHeap.peek() > minHeap.peek())) {
            minHeap.add(maxHeap.poll());
        }
        if(minHeap.size()-maxHeap.size()>1) maxHeap.add(minHeap.poll());
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size()) return (double)(minHeap.peek()+maxHeap.peek())/2;
        if(minHeap.size() > maxHeap.size()) return minHeap.peek();
        else return maxHeap.peek();
    }
}
