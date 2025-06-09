package patterns.graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MST {
    public int spanningTree(int n, List<List<List<Integer>>> adj) {
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        boolean[] visited = new boolean[n];
        pq.add(new int[]{0, 0});
        int sum = 0;

        while (!pq.isEmpty()) {
            int[] p = pq.poll();

            int node = p[1];
            int wt = p[0];

            if (visited[node]) continue;

            visited[node] = true;
            sum += wt;
            for (List<Integer> it : adj.get(node)) {
                int adjNode = it.get(0);
                int edgeWt = it.get(1);
                if (!visited[adjNode]) {
                    pq.add(new int[]{edgeWt, adjNode});
                }
            }
        }

        return sum;
    }
}
