package patterns.stack;


import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
    private final Queue<Integer> queue;

    public QueueStack() {
        this.queue = new LinkedList<>();
    }

    public void push(int x) {
        int n = queue.size();

        queue.add(x);

        for (int i = 0; i < n; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        int n = queue.peek();
        queue.poll();

        return n;
    }

    public int top() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
