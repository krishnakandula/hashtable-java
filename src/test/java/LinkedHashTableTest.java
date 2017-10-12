import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Krishna Chaitanya Kandula on 10/9/2017.
 */
public class LinkedHashTableTest {

    private LinkedHashTable hashTable;

    @Before
    public void setup() {
        hashTable = new LinkedHashTable();
        hashTable.put("test", 1);
        hashTable.put("test2", 2);
        hashTable.put("test3", 3);
        hashTable.put("test4", 4);
    }

    @Test
    public void testPutAndGet() {
        assertTrue(1 == hashTable.get("test"));
        assertTrue(2 == hashTable.get("test2"));
        assertTrue(3 == hashTable.get("test3"));
        assertTrue(4 == hashTable.get("test4"));

        hashTable.put("test", 5);
        assertTrue(5 == hashTable.get("test"));


    }

    @Test
    public void testClear() {
        hashTable.clear();
        assertEquals(0, hashTable.size());
        assertTrue(hashTable.isEmpty());
        assertNull(hashTable.get("test"));
        assertNull(hashTable.get("test2"));
        assertNull(hashTable.get("test3"));
        assertNull(hashTable.get("test4"));
    }

    @Test
    public void testRemove() {
        assertTrue(1 == hashTable.get("test"));
        assertTrue(2 == hashTable.get("test2"));
        hashTable.remove("test");
        hashTable.remove("test2");
        assertNull(hashTable.get("test"));
        assertNull(hashTable.get("test2"));
    }
}