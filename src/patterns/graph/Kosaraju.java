package patterns.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Kosaraju {
    private void dfs(int node, int[] vis,
                     List<List<Integer>> adj,
                     Stack<Integer> st) {

        vis[node] = 1;

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, adj, st);
            }
        }

        st.push(node);
    }

    private void helperDFS(int node, int[] vis,
                           List<List<Integer>> adjT) {
        vis[node] = 1;

        for (int it : adjT.get(node)) {
            if (vis[it] == 0) {
                helperDFS(it, vis, adjT);
            }
        }
    }

    public int kosaraju(int V, List<List<Integer>> adj) {
        int[] vis = new int[V];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }

        List<List<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            vis[i] = 0;

            for (int it : adj.get(i)) {
                adjT.get(it).add(i);
            }
        }

        int count = 0;

        while (!st.isEmpty()) {
            int node = st.pop();

            if (vis[node] == 0) {
                count += 1;
                helperDFS(node, vis, adjT);
            }
        }

        return count;
    }
}
