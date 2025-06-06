package patterns.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    // === 1. Standard DFS for Adjacency List ===
    public void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                dfs(nei, graph, visited);
            }
        }
    }

    // === 2. DFS for Counting Connected Components ===
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = buildGraph(n, edges);
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                count++;
            }
        }

        return count;
    }

    // === 3. DFS for Detecting Cycle in Undirected Graph ===
    public boolean hasCycleUndirected(int node, int parent, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                if (hasCycleUndirected(nei, node, graph, visited)) return true;
            } else if (nei != parent) {
                return true;
            }
        }

        return false;
    }

    // === 4. DFS for Detecting Cycle in Directed Graph ===
    public boolean hasCycleDirected(int node, int[] state, List<List<Integer>> graph) {
        // state: 0 = unvisited, 1 = visiting, 2 = visited
        if (state[node] == 1) return true;
        if (state[node] == 2) return false;

        state[node] = 1;

        for (int nei : graph.get(node)) {
            if (hasCycleDirected(nei, state, graph)) return true;
        }

        state[node] = 2;
        return false;
    }

    // === 5. Topological Sort using DFS (Directed Acyclic Graph) ===
    public void topologicalSort(int node, List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                topologicalSort(nei, graph, visited, stack);
            }
        }

        stack.push(node);
    }

    // === 6. DFS on Grid (e.g., Flood Fill / Islands) ===
    private static final int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public void dfsGrid(int[][] grid, int r, int c, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= cols || visited[r][c] || grid[r][c] == 0)
            return;

        visited[r][c] = true;

        for (int[] dir : DIRS) {
            dfsGrid(grid, r + dir[0], c + dir[1], visited);
        }
    }

    private List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}
