package patterns.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MonotonicQueue {
    Deque<Integer> deque = new ArrayDeque<>();

    public void push(int x) {
        while (!deque.isEmpty() && deque.peekLast() < x) deque.pollLast();
        deque.addLast(x);
    }

    public void pop(int val) {
        if (!deque.isEmpty() && deque.peekFirst() == val) {
            deque.pollFirst();
        }
    }

    public int max() {
        return deque.peekFirst();
    }
}
