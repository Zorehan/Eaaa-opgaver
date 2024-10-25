package dictionaryelev;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DictionaryList<K, V> implements Dictionary<K, V> {


    private static final int N = 13;
    private int size;

    private List<Entry<K, V>>[] table;

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public DictionaryList() {
        table = new List[N];
        for (int i = 0; i < N; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }

    @Override
    //normalt ville det være O(1+n^k) normalt O=(k)
    public V get(K key) {
        int index = getIndex(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    //O=(1)
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    //average ville det være O(1+n^k) normalt O=(k)
    public V put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Neither key nor value can be null.");
        }
        int index = getIndex(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
        return null;
    }

    @Override
    //average ville det være O(1+n^k) normalt O=(k)
    public V remove(K key) {
        int index = getIndex(key);
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                V removedValue = entry.value;
                table[index].remove(entry);
                size--;
                return removedValue;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % N;
    }
}