/**
 * Created by Krishna Chaitanya Kandula on 10/9/2017.
 */
public class HashEntry {
    public String key;
    public int value;

    public HashEntry next;

    public HashEntry(String key, int value) {
        this.key = key;
        this.value = value;
    }
}
