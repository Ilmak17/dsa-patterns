package patterns.queue;

public class ArrQueue {

    private final int[] queue;
    private final int capacity;

    private int tailIdx;
    private int headIdx;
    private int size;

    public ArrQueue() {
        this.capacity = 16;
        this.queue = new int[capacity];
        this.tailIdx = -1;
        this.size = 0;
    }

    public void push(int x) {
        if (size == capacity) return;

        if (tailIdx == -1) {
            headIdx = 0;
            tailIdx = 0;
        } else {
            tailIdx = (tailIdx + 1) % capacity;
        }

        queue[tailIdx] = x;
        size++;
    }

    public int pop() {
        if (isEmpty()) return -1;

        int popped = queue[headIdx];

        headIdx = size == 1 ? 0 : headIdx + 1 % capacity;
        size--;

        return popped;
    }

    public int peek() {
        if (isEmpty()) return -1;

        return queue[headIdx];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
