class Solution {
    public int lastStoneWeight(int[] stones) {
        if (null == stones || stones.length == 0) return 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int top1 = maxHeap.poll();
            int top2 = maxHeap.poll();

            if (top1 != top2) {
                maxHeap.offer(top1 - top2);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
