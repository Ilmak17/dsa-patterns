package datastructures;

import java.util.Arrays;

public class ArrayList<T> {
    private T[] data;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void add(T element) {
        data[size++] = element;
    }

    public T get(int index) {
        checkIndex(index);

        return data[index];
    }

    public T remove(int idx) {
        checkIndex(idx);
        T removed = data[idx];
        for (int i = idx; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[--size] = null;

        return removed;
    }

    private int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            data = Arrays.copyOf(data, size * 2);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    }
}
