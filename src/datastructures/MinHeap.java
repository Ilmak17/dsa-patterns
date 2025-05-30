package datastructures;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private final List<Integer> arr;

    public MinHeap() {
        this.arr = new ArrayList<>();
    }

    public void buildHeap(List<Integer> elements) {
        arr.clear();
        arr.addAll(elements);

        for (int i = (arr.size() / 2) - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    private void heapifyUp(int idx) {
        int parentIdx = (idx - 1) / 2;

        if (idx > 0 && arr.get(parentIdx) > arr.get(idx)) {
            int tmp = arr.get(parentIdx);
            arr.set(parentIdx, arr.get(idx));
            arr.set(idx, tmp);

            heapifyUp(parentIdx);
        }
    }

    private void heapifyDown(int idx) {
        int leftChildIdx = idx * 2 + 1;
        int rightChildIdx = idx * 2 + 2;

        int smallestIdx = idx;

        if (leftChildIdx < arr.size() && arr.get(leftChildIdx) < arr.get(smallestIdx)) {
            smallestIdx = leftChildIdx;
        }

        if (rightChildIdx < arr.size() && arr.get(rightChildIdx) < arr.get(smallestIdx)) {
            smallestIdx = rightChildIdx;
        }

        if (smallestIdx != idx) {
            int tmp = arr.get(smallestIdx);
            arr.set(smallestIdx, arr.get(idx));
            arr.set(idx, tmp);

            heapifyDown(smallestIdx);
        }
    }

    public void insert(int key) {
        arr.add(key);
        heapifyUp(arr.size() - 1);
    }

    public void changeKey(int idx, int newKey) {
        if (arr.get(idx) > newKey) {
            arr.set(idx, newKey);
            heapifyUp(idx);
        } else {
            arr.set(idx, newKey);
            heapifyDown(idx);
        }
    }

    public int extractMin() {
        if (arr.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int min = arr.getFirst();
        int last = arr.removeLast();

        if (!arr.isEmpty()) {
            arr.set(0, last);
            heapifyDown(0);
        }

        return min;
    }

    public boolean isEmpty() {
        return arr.isEmpty();
    }

    public int peek() {
        return arr.getFirst();
    }

    public int size() {
        return arr.size();
    }
}
