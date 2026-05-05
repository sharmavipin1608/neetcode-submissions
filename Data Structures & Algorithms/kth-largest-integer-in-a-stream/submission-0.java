class KthLargest {
    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>((a,b) -> Integer.compare(a, b));

        for (int num : nums) {
            add(num);
        }    
    }
    
    public int add(int val) {
        if (heap.size() == k) {
            if (val > heap.peek()) {
                heap.poll();
                heap.offer(val);
            }
        } else {
            heap.offer(val);
        }

        return heap.peek();
    }
}
