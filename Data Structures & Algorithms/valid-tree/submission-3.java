class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = n;
        for (int[] edge : edges) {
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);

            if (root1 != root2) {
                parent[root1] = root2;
                components--;
            
            } else if (root1 == root2) {
                return false;
            }
        }

        return components == 1 ? true : false;
    }

    
    private int find(int[] parent, int node) {
        if (parent[node] == node) return node;
        return parent[node] = find(parent, parent[node]);
    }
}
