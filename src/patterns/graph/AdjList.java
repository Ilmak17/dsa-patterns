package patterns.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AdjList {
    private final int vertices;
    private final List<List<Integer>> adjList;

    public AdjList(int vertices) {
        this.vertices = vertices;
        this.adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
    }

    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (visited[vertex]) continue;

            System.out.print(vertex + " ");
            visited[vertex] = true;

            for (int nei : adjList.get(vertex)) {
                if (!visited[nei]) {
                    stack.push(nei);
                }
            }
        }
    }

    public void bfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            System.out.print(vertex + " ");

            for (int nei : adjList.get(vertex)) {
                if (!visited[nei]) {
                    queue.add(nei);
                    visited[nei] = true;
                }
            }
        }
    }
}
