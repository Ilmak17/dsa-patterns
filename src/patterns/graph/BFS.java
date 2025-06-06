package patterns.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    // === 1. Standard BFS for Adjacency List ===
    public void bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int nei : graph.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    queue.offer(nei);
                }
            }
        }
    }

    // === 2. Shortest Path in Unweighted Graph (BFS gives shortest path) ===
    public int shortestPath(int start, int end, List<List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        int[] dist = new int[graph.size()];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == end) return dist[node];

            for (int nei : graph.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    dist[nei] = dist[node] + 1;
                    queue.offer(nei);
                }
            }
        }

        return -1;
    }

    // === 3. BFS on Grid (Shortest Path or Region Expansion) ===
    private static final int[][] DIRS = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int bfsGrid(int[][] grid, int sr, int sc) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];

                // process cell here

                for (int[] dir : DIRS) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                            !visited[nr][nc] && grid[nr][nc] == 0) {
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            steps++;
        }

        return steps;
    }

    // === 4. Multi-Source BFS (start from multiple points) ===
    public int multiSourceBFS(List<int[]> sources, int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        for (int[] src : sources) {
            queue.offer(src);
            visited[src[0]][src[1]] = true;
        }

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int r = cur[0], c = cur[1];

                // process cell

                for (int[] dir : DIRS) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nc >= 0 && nr < rows && nc < cols &&
                            !visited[nr][nc] && grid[nr][nc] == 0) {
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            steps++;
        }

        return steps;
    }

    // === 5. BFS with State (Used in 0/1 matrix or jumping states) ===
    public static class State {
        int row, col, cost;
        public State(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    public void bfsWithState(int[][] grid) {
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(0, 0, 0));
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            // you can now access cur.row, cur.col, cur.cost
        }
    }

    // === 6. Is Bipartite ===
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); // -1 = unvisited

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = 0;

                while (!queue.isEmpty()) {
                    int node = queue.poll();

                    for (int nei : graph[node]) {
                        if (color[nei] == -1) {
                            color[nei] = 1 - color[node];
                            queue.offer(nei);
                        } else if (color[nei] == color[node]) {
                            return false; // adjacent node has same color
                        }
                    }
                }
            }
        }

        return true;
    }
}
