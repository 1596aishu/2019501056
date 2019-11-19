/**
 * @author Aiswarya
 */
import java.util.*;
import java.util.Arrays;

class bsst<Key extends Comparable<Key> , Value> {
    Key[] keys;
    Value[] values;
    private int n;
    private int capacity;

    bsst() {
        keys = (Key[]) new Comparable[1];   //constuctor to initialise the keys and values
        values = (Value[]) new Object[1];
        n = 0;
    }

    public int size() {
        return n;
    }    

    /**
     * resizes the array 
     * @param capacity
     */
    public void resize(int capacity) {
        Key[] x = (Key[]) new Comparable[capacity];
        Value[] y = (Value[]) new Object[capacity];
        for (int  i = 0; i < n; i++)  {
            x[i] = keys[i];
            y[i] = values[i];
        }
        values = y;
        keys   = x; 
    }    

    public void put(Key key, Value value) {
        if(value == null) {
            delete(key);
            return;
        }        
        if( n == 0) {
            keys[n] = key;
            values[n] = value;
            n++;
        }
        else {  
            if ( n == keys.length) resize(keys.length * 2);
            int x = key.compareTo(keys[n - 1]);
            if ( x > 0 ) {
                keys[n] = key;
                values[n] = value;
            }
            int i = rank(key);
            if ( i < n && keys[i].compareTo(key) == 0) {
                values[i] = value;
                return;
            }      
            for (int j = n; j> i; j--) {
                keys[j] = keys[ j - 1];
                values[j] = values[j - 1];
            }
            keys[i] = key;
            values[i] = value;
            n++;           
        }    
    }     


    public int rank(Key key) {
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0)  high = mid - 1; 
            else if (cmp > 0) low = mid + 1;
            else return mid;
            }
        return low;   
    }
        
    public void delete(Key key) {
        int  i = rank(key);
        for (int j = i; j < n - 1; j++) {
            keys[j] = keys[ j + 1];
            values[j] = values[j+1];
        }
        n--;
        keys[n] = null;
        values[n] = null;
    }

    public String keyvalue() {
        String ss = "";
        String vv = "";
        for (int i = 0 ; i < n ; i++) {
            ss += " " +keys[i];
            vv += " "+ values[i];
        }
        System.out.println(vv);
        return ss;
    }
    public static void main(String[] args){
        bsst bst = new bsst();
        bst.put("A", 1);
        bst.put("b", 5);
        bst.put("p", 4);
        bst.put("s", 10);
        bst.put("A", 15);
        bst.put("a", 3);
        System.out.println(bst.keyvalue());
        bst.delete("s");
        System.out.println(bst.keyvalue());


    }
}




    