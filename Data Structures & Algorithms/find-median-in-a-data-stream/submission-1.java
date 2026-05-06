class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));    
    }
    
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        return maxHeap.size() == minHeap.size() ? (minHeap.peek() + maxHeap.peek())/2.0 : (double)minHeap.peek();
    }
}
