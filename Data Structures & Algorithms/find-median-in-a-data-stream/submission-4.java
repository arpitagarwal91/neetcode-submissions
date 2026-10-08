class MedianFinder {

    PriorityQueue<Integer> first;
    PriorityQueue<Integer> second;

    public MedianFinder() {
        this.first = new PriorityQueue<>((a,b) -> b-a);
        this.second = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        this.first.add(num);
        if(this.first.size()-this.second.size()>1){
            this.second.add(this.first.poll());
        }
        if(!second.isEmpty() && this.second.peek()<this.first.peek()){
            this.first.add(this.second.poll());
            this.second.add(this.first.poll());
        }
    }
    
    public double findMedian() {
        if((this.first.size()+this.second.size())%2==1) return this.first.peek();
        return (double)(this.first.peek()+this.second.peek())/2.0;
    }
}
