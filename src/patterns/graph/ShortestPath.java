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
}
