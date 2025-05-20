package patterns.linkedlist;

import java.util.HashMap;
import java.util.Map;

class LRUNode {
    int key;
    int val;
    LRUNode next;
    LRUNode prev;

    public LRUNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    private final Map<Integer, LRUNode> cache;
    private final int capacity;
    private final LRUNode right;
    private final LRUNode left;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.right = new LRUNode(0, 0);
        this.left = new LRUNode(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            LRUNode node = cache.get(key);
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
        LRUNode newNode = new LRUNode(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > capacity) {
            LRUNode lastNode = left.next;
            remove(lastNode);
            cache.remove(lastNode.key);
        }
    }

    private void insert(LRUNode node) {
        LRUNode prev = right.prev;
        prev.next = node;
        node.prev = prev;
        right.prev = node;
        node.next = right;
    }

    private void remove(LRUNode node) {
        LRUNode prev = node.prev;
        LRUNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}
