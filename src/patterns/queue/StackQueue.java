package patterns.queue;

import java.util.Stack;

public class StackQueue {
    private final Stack<Integer> in;
    private final Stack<Integer> out;

    public StackQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        if (out.isEmpty()) return -1;

        return out.pop();
    }

    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        if (out.isEmpty()) return -1;

        return out.peek();
    }

    public boolean isEmpty() {
        return in.isEmpty() && out.isEmpty();
    }
}
