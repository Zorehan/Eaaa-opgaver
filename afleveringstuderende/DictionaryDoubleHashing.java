package afleveringstuderende;

public class DictionaryDoubleHashing<K, V> implements Dictionary<K, V> {
    private Entry<K, V>[] table;
    private int size;

    private final Entry<K, V> DELETED = new Entry<>(null, null);
    private static final int STARTING_SIZE = 10;

    public DictionaryDoubleHashing() {
        table = new Entry[STARTING_SIZE];
        size = 0;
    }

    private int hash1(K key) {
        return key.hashCode() % table.length;
    }

    private int hash2(K key) {
        return 7 - (key.hashCode() % 7);
    }

    //O=(n)
    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;

        for (Entry<K, V> entry : oldTable) {
            if (entry != null && entry != DELETED) {
                put(entry.key, entry.value);
            }
        }
    }

    //Tidskompleksiteten til get er O=(n)
    @Override
    public V get(K key) {
        int hash = hash1(key);
        int step = hash2(key);

        for (int i = 0; i < table.length; i++) {
            int index = (hash + i * step) % table.length;
            Entry<K, V> entry = table[index];

            if (entry == null) {
                return null;
            }
            if (entry != DELETED && entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    // O=(1)
    public boolean isEmpty() {
        return size == 0;
    }

    //tidskompleksiteten er O=1, kan dog være O=(n) hvis tabellet er tæt på fyldt
    @Override
    public V put(K key, V value) {
        if (size >= table.length * 0.5) {
            resize();
        }

        int hash = hash1(key);
        int step = hash2(key);

        for (int i = 0; i < table.length; i++) {
            int index = (hash + i * step) % table.length;
            Entry<K, V> entry = table[index];

            if (entry == null || entry == DELETED) {
                table[index] = new Entry<>(key, value);
                size++;
                return null;
            }

            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }

        return null;
    }

    @Override
    //Tidskompleksitet O=(n)
    public V remove(K key) {
        int hash = hash1(key);
        int step = hash2(key);

        for (int i = 0; i < table.length; i++) {
            int index = (hash + i * step) % table.length;
            Entry<K, V> entry = table[index];

            if (entry == null) {
                return null;
            }
            if (entry.key.equals(key)) {
                V value = entry.value;
                table[index] = DELETED;
                size--;
                return value;
            }
        }
        return null;
    }

    //O=(1)
    @Override
    public int size() {
        return size;
    }

    public void writeOut() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + "\t" + table[i]);
        }
    }

    public static class Entry<K,V>{
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
        public String toString(){
            return "(" +key + " , " + value + ")";
        }
    }
}
