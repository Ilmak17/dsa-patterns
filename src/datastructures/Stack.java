package datastructures;

import java.util.Arrays;

public class Stack<T> {
    private T[] data;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T value) {
        ensureCapacity();
        data[size++] = value;
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        T value = data[--size];
        data[size] = null;
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }
}
