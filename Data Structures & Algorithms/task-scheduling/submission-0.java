class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char ch : tasks) {
            freq[ch - 'A'] += 1;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) maxHeap.offer(freq[i]);
        }

        Queue<int[]> queue = new ArrayDeque<>(); //freq, time
        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int current = maxHeap.poll();
                current -= 1;

                if (current != 0) {
                    queue.offer(new int[]{current, time + n});
                }
            }

            if (!queue.isEmpty() && queue.peek()[1] <= time) {
                maxHeap.offer(queue.poll()[0]);
            }
        } 

        return time;   
    }
}
