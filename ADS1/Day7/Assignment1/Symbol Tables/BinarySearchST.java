/** This class is about BinarySearch symbol table
 * which gives some of the methods of BSST.
 * @author Aiswarya
 */
import java.util.*;
class BinarySearchST<Key extends Comparable<Key>, Value> {
    Key[] keys;
    Value[] values;
    int n = 0;
    int capacity = 1;

    BinarySearchST() {
        keys = (Key[]) new Comparable[1];
        values = (Value[]) new Object[1];
        n = 0;
    }
    /**
     * 
     * @return the integer value size of bsst
     */

    public int size() {
        return n;
    }
    /**
     * 
     * @param capacity the amount of size  to be increased
     */

    public void resize(int capacity)  {
        Key[]   temp1 = (Key[])   new Comparable[capacity];
        Value[] temp2 = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp1[i] = keys[i];
            temp2[i] = values[i];
        }
        values = temp2;
        keys = temp1;
    }
    /**
     * 
     * @return true if empty else false
     */

    public boolean isEmpty()  { 
        return size() == 0;
    }
    /**
     * 
     * @param key the key which is been searched to find 
     * @return true if the key is present
     */

    public boolean contains(Key key)  {
        return get(key) != null;
    }
/**
 * 
 * @param key the key which has a value with it
 * @param value which is to be stored at particular position. 
 */
    
    

    public void put(Key key, Value value)  {
        if (value == null) {
            delete(key);
            return;
        }
       
     
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0)  {
            values[i] = value;
            return;
        }
        if (n == keys.length)
            resize(keys.length * 2);
        for (int j = n; j > i; j--)  {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }

    /**
     * 
     * @param key the key to which a value is associated
     * @return value corresponding to that key
     */
    public Value get(Key key)  {
        if(isEmpty())
            return null;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0)
            return values[i];
        return null;
    }    
  /**
   * 
   * @param key key which is used 
   * to know how many keys are actually present before it
   * @return the integer 
   */

    public int rank(Key key)  {
        int low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int toCompare  =  key.compareTo(keys[mid]);
            if (toCompare < 0)
                high = mid - 1;
             else if (toCompare > 0)
                low = mid + 1;
             else 
                return mid;
        }
        return low;
    }

    public void delete(Key key)  {
        int i = rank(key);

        for (int j = i; j < n - 1; j++)  {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        n--;
        keys[n] = null;
        values[n] = null;
    }

    public void deleteMin()  {
        delete(min());
    }

    public void deleteMax()  {
        delete(max());
    }

    public Key max()  {
        return keys[n - 1];
    }

    public Key min() {
        return keys[0];
    }

    public Key floor(Key key) {
        int i = rank(key);
        if (i == 0) 
            return null;

        else if (i < n && key.compareTo(keys[i]) == 0) 
            return keys[i];
        else 
            return keys[i-1];
    }

    public String keys() {
        String out = "";
        for (int i = 0; i < n; i++) {
            out += keys[i] + " ";
        }
        return out;
    }
}

