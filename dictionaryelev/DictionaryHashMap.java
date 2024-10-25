package dictionaryelev;

import java.util.HashMap;
import java.util.Map;

public class DictionaryHashMap<K, V> implements Dictionary<K, V> {

    private Map<K, V>[] tabel;
    private static final int N = 13;
    private int size = 0;

    public DictionaryHashMap() {
        tabel = new HashMap[N];
        for (int i = 0; i < N; i++) {
            tabel[i] = new HashMap<K, V>();
        }
    }

    @Override

    public V get(K key) {
        int index = getIndex(key);
        return tabel[index].get(key);
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value cannot be null");
        }
        int index = getIndex(key);
        V oldValue = tabel[index].put(key, value);
        if (oldValue == null) {
            size++;
        }
        return oldValue;
    }

    @Override
    public V remove(K key) {
        int index = getIndex(key);
        V removedValue = tabel[index].remove(key);
        if (removedValue != null) {
            size--;
        }
        return removedValue;
    }

    // O=(1)
    @Override
    public int size() {
        return size;
    }


    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % N;
    }
}