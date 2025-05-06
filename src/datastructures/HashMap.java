package datastructures;

public class HashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Entry<K, V>[] table;
    private int size;

    public HashMap() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        if ((double) size / table.length > LOAD_FACTOR) {
            resize();
        }

        int index = findSlot(key);
        if (table[index] == null || table[index].isDeleted) {
            table[index] = new Entry<>(key, value);
            size++;
        } else {
            table[index].value = value;
        }
    }

    public V get(K key) {
        int index = findSlot(key);
        if (table[index] == null || table[index].isDeleted) {
            return null;
        }
        return table[index].value;
    }

    public V remove(K key) {
        int index = findSlot(key);
        if (table[index] == null || table[index].isDeleted) {
            return null;
        }

        V value = table[index].value;
        table[index].isDeleted = true;
        size--;
        return value;
    }

    public boolean containsKey(K key) {
        int index = findSlot(key);
        return table[index] != null && !table[index].isDeleted;
    }

    public int size() {
        return size;
    }


    private int findSlot(K key) {
        int index = Math.abs(key.hashCode()) % table.length;

        while (table[index] != null && (!table[index].key.equals(key) || table[index].isDeleted)) {
            index = (index + 1) % table.length;
        }

        return index;
    }

    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;

        for (Entry<K, V> entry : oldTable) {
            if (entry != null && !entry.isDeleted) {
                put(entry.key, entry.value);
            }
        }
    }

    private static class Entry<K, V> {
        K key;
        V value;
        boolean isDeleted;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.isDeleted = false;
        }
    }
}
