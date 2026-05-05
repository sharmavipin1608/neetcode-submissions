class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));

        for (int[] point : points) {
            int dist = (point[0] * point[0]) + (point[1] * point[1]);
            minHeap.offer(new int[]{dist, point[0], point[1]});
        }    

        //while (minHeap.size() > k) minHeap.poll();

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] point = minHeap.poll();
            result[i] = new int[] {point[1], point[2]};
        }

        return result;
    }
}
