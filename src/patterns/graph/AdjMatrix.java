package patterns.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjMatrix {
    private final int vertices;
    private final int[][] matrix;

    public AdjMatrix(int vertices) {
        this.vertices = vertices;
        this.matrix = new int[vertices][vertices];
    }

    public void addEdge(int from, int to) {
        matrix[from][to] = 1;
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

            for (int i = vertices - 1; i >= 0; i--) {
                if (matrix[vertex][i] == 1 && !visited[i]) {
                    stack.push(i);
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

            for (int i = 0; i < vertices; i++) {
                if (matrix[vertex][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
