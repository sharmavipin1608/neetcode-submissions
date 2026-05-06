class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        int components = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int pu = find(parent, u);
            int pv = find(parent, v);

            if (pu != pv) {
                if (rank[pu] > rank[pv]) {
                    parent[pv] = pu;
                    rank[pu] += rank[pv];
                } else {
                    parent[pu] = pv;
                    rank[pv] += rank[pu];
                }

                components--;
            }
        }

        return components;
    }

    private int find(int[] parent, int node) {
        if (parent[node] == node) return node;
        return find(parent, parent[node]);
    }
}
