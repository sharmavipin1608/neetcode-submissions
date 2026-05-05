class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) return false;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : adjList.get(current)) {
                if (!visited.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }

        return visited.size() == n;
    }
}
