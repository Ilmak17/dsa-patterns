package datastructures;

public class DoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public T get(int index) {
        checkIndex(index);
        Node<T> curr = (index < size / 2) ? head : tail;
        if (index < size / 2) {
            for (int i = 0; i < index; i++) curr = curr.next;
        } else {
            for (int i = size - 1; i > index; i--) curr = curr.prev;
        }
        return curr.value;
    }

    public T remove(int index) {
        checkIndex(index);
        Node<T> toRemove;
        if (index == 0) {
            toRemove = head;
            head = head.next;
            if (head != null) head.prev = null;
        } else if (index == size - 1) {
            toRemove = tail;
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            toRemove = head;
            for (int i = 0; i < index; i++) toRemove = toRemove.next;
            toRemove.prev.next = toRemove.next;
            toRemove.next.prev = toRemove.prev;
        }
        size--;
        return toRemove.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;

        Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }

}
