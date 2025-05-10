package datastructures;

public class HashMap<K, V> {
    private static final int CAPACITY = 16;

    private final Bucket[] table;

    public HashMap() {
        this.table = new Bucket[CAPACITY];
    }

    public void put(K key, V value) {
        int index = findSlot(key);
        table[index] = new Bucket<>(key, value);
    }

    public V get(K key) {
        int index = findSlot(key);
        Bucket<K, V> bucket = table[index];
        if (bucket != null && bucket.key.equals(key)) {
            return bucket.value;
        }
        return null;
    }

    public boolean containsKey(K key) {
        int index = findSlot(key);
        return table[index] != null && table[index].key.equals(key);
    }

    private int findSlot(K key) {
        int index = Math.abs(key.hashCode()) % CAPACITY;

        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + 1) % CAPACITY;
        }

        return index;
    }

    private static class Bucket<K, V> {
        K key;
        V value;

        Bucket(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
