/**
 * Created by Krishna Chaitanya Kandula on 10/9/2017.
 */
public interface CustomHashTable {

    void put(String key, int value);

    Integer get(String key);

    boolean contains(int value);

    boolean containsKey(String key);

    boolean isEmpty();

    Integer remove(String key);

    int size();

    void clear();
}
