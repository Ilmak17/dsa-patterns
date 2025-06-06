package patterns.graph;

public class UnionFind {

    private final int[] parent;
    private final int[] rank;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) return;

        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
        }
    }
}

class UnionFindPatterns {
    public boolean hasCycle(int[][] edges, int n) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (uf.find(u) == uf.find(v)) {
                return true; // cycle
            }
            uf.union(u, v);
        }
        return false;
    }

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int components = n;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (uf.find(u) != uf.find(v)) {
                uf.union(u, v);
                components--;
            }
        }

        return components;
    }
}
