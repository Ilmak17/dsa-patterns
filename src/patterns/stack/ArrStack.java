package patterns.stack;

public class ArrStack {
    private final int[] stack;
    private int lastIdx;

    public ArrStack() {
        this.stack = new int[1000];
        this.lastIdx = -1;
    }

    public int push(int x) {
        stack[++lastIdx] = x;

        return stack[lastIdx];
    }

    public int pop() {
        if (isEmpty()) return -1;
        return stack[lastIdx--];
    }

    public int peek() {
        if (isEmpty()) return -1;
        return stack[lastIdx];
    }

    public boolean isEmpty() {
        return stack.length == 0;
    }
}
