/**
 * Created by Krishna Chaitanya Kandula on 10/9/2017.
 */
public class LinkedHashTable implements CustomHashTable {

    private static final int DEFAULT_CAPACITY = 100;

    private HashEntry[] hashArray;
    private int size = 0;

    public LinkedHashTable() {
        hashArray = new HashEntry[DEFAULT_CAPACITY];
    }

    public LinkedHashTable(int capacity) {
        hashArray = new HashEntry[capacity];
    }

    @Override
    public void put(String key, int value) {
        int hash = getHash(key);
        if(hashArray[hash] == null) {
            hashArray[hash] = new HashEntry(key, value);

        } else {
            HashEntry entry = hashArray[hash];
            while (entry != null && !entry.key.equals(key)) entry = entry.next;
            if(entry != null && entry.key.equals(key)) {
                entry.value = value;
            } else {
                entry = new HashEntry(key, value);
            }
        }
        size++;
    }

    @Override
    public Integer get(String key) {
        HashEntry entry = hashArray[getHash(key)];
        if(entry == null) return null;

        while(entry != null && !entry.key.equals(key)) entry = entry.next;
        return entry.value;
    }

    @Override
    public boolean contains(int value) {
        return false;
    }

    @Override
    public boolean containsKey(String key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Integer remove(String key) {
        int hash = getHash(key);
        HashEntry e = hashArray[hash];
        if(e == null) return null;

        HashEntry prev = e;
        while(e != null && !e.key.equals(key)) {
            prev = e;
            e = e.next;
        }

        if(e != null) {
            int value = e.value;
            prev.next = e.next;
            return value;
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        for(int i = 0; i < hashArray.length; i++) hashArray[i] = null;
        size = 0;
    }

    private int getHash(String key) {
        return key.hashCode() % hashArray.length;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(HashEntry e : hashArray) {
            while(e != null) {
                s.append(String.format("Key: %s     Value: %d\n", e.key, e.value));
            }
        }
        return s.toString();
    }
}
