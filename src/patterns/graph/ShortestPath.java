package patterns.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPath {

    public int[] djikstra(int[][] edges, int n, int start) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>())
                    .add(new int[]{edge[1], edge[2]});

        }

        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[]{start, 0});

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        boolean[] visited = new boolean[n];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int curDist = cur[1];

            if (visited[node]) continue;
            visited[node] = true;

            if (!adj.containsKey(node)) continue;

            for (int[] neighbor : adj.get(node)) {
                int next = neighbor[0];
                int weight = neighbor[1];
                int newDist = curDist + weight;

                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    q.offer(new int[]{next, newDist});
                }
            }
        }

        return dist;
    }

    public int[] bellmanFord(int n, List<List<Integer>> edges, int start) {

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);

        dist[start] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (List<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if (dist[u] != 1e9 &&
                        dist[u] + wt < dist[v]) {

                    dist[v] = dist[u] + wt;
                }
            }
        }

        for (List<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            if (dist[u] != 1e9 &&
                    dist[u] + wt < dist[v]) {

                return new int[]{-1};
            }
        }

        return dist;
    }

    public void floydWarshall(int[][] matrix) {
        int n = matrix.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] == -1 || matrix[k][j] == -1) continue;
                    if (matrix[i][j] == -1) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    } else {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }
    }
}
