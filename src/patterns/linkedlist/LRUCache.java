package patterns.linkedlist;

import java.util.HashMap;
import java.util.Map;

class LRUNode {
    int key;
    int val;
    DoublyLinkedList next;
    DoublyLinkedList prev;

    public LRUNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    private final Map<Integer, DoublyLinkedList> cache;
    private final int capacity;
    private final DoublyLinkedList right;
    private final DoublyLinkedList left;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.right = new DoublyLinkedList(0, 0);
        this.left = new DoublyLinkedList(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DoublyLinkedList node = cache.get(key);
            remove(node);
            insert(node);

            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
            cache.remove(key);
        }
        DoublyLinkedList newNode = new DoublyLinkedList(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > capacity) {
            DoublyLinkedList lastNode = left.next;
            remove(lastNode);
            cache.remove(lastNode.key);
        }
    }

    private void insert(DoublyLinkedList node) {
        DoublyLinkedList prev = right.prev;
        prev.next = node;
        node.prev = prev;
        right.prev = node;
        node.next = right;
    }

    private void remove(DoublyLinkedList node) {
        DoublyLinkedList prev = node.prev;
        DoublyLinkedList next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}
