class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        //List<int[]> result = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int pu = find(parent, u);
            int pv = find(parent, v);

            if (pu == pv) {
                return edge;
            } else {
                if (rank[pu] > rank[pv]) {
                    parent[pv] = pu;
                    rank[pu] += rank[pv];
                } else {
                    parent[pu] = pv;
                    rank[pv] += rank[pu];
                }
            }
        }

        return new int[0];
    }

    private int find(int[] parent, int node) {
        if (parent[node] == node) return node;
        return parent[node] = find(parent, parent[node]);
    }
}
