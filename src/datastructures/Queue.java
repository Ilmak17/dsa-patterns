package datastructures;

public class Queue<T> {
    private static final int CAPACITY = 16;
    private T[] elements;
    private int start;
    private int end;
    private int size;

    public Queue() {
        this.elements = (T[]) new Object[CAPACITY];
        this.start = 0;
        this.end = 0;
        this.size = 0;
    }

    public void add(T value) {
        if (size == CAPACITY) {
            throw new IllegalStateException("Queue is full");
        }

        elements[end] = value;
        end = (end + 1) % CAPACITY;
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");

        T value = elements[start];
        elements[start] = null;
        start = (start + 1) % CAPACITY;
        size--;

        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return elements[start];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
