//@author Aiswarya
import java.util.*;
public class linearProbing<Key, Value>{
    private static final int CAPACITY = 4;
    public int n;           
    public int m;           
    public Key[] keys;      
    public Value[] vals; 
    public linearProbing(){
        this(CAPACITY);
    }
    public linearProbing(int capacity){
        m = capacity;
        n = 0;
        keys = (Key[]) new Object[m];
        vals = (Value[]) new Object[m];
    }
    public int size(){
        return n;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public boolean contains(Key key) {
        return get(key) != null;
    }
    private void resize(int capacity) {
        linearProbing<Key, Value> temp = new linearProbing<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m = temp.m;
    }
    private int hash(Key key){
        return (key.hashCode()) % m;
    }
    public void put(Key key, Value val){
        if (val == null){
            delete(key);
            return;
        }
        if (n >= m/2) resize(2*m);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
    public Value get(Key key){
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }
    public Iterable<Key> keys(){
        Queue<Key> Q = new Queue<Key>();
        for (int i = 0; i < m; i++)
            if (keys[i] != null) Q.enqueue(keys[i]);
        return Q;
    }
    public void delete(Key key){
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % m;
        while (keys[i] != null){
            Key   Rkey = keys[i];
            Value Rval = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(Rkey, Rval);
            i = (i + 1) % m;
        }
        n--;
        if (n > 0 && n <= m/8) resize(m/2);
        check();
    }    
    private boolean check() {
        if (m < 2*n) {
            System.err.println("Hash table size m = " + m + "; array size n = " + n);
            return false;
        }
        for (int i = 0; i < m; i++) {
            if (get(keys[i]) != vals[i]) {
                System.err.println("get[" + keys[i] + "] = " + get(keys[i]) + "; vals[i] = " + vals[i]);
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int N = 1000000;
        Random rand = new Random();
        int i,j;
        int count = 0;
        linearProbing hash = new linearProbing();
        for(i = 0; i< N/2;i++) hash.put(rand.nextInt(N), rand.nextInt(N));
        for(j = 0;j<N;j+=100){
            // System.out.println(j);
            if(hash.get(j)!=null) count++;
        }
        System.out.println("Count: "+count);
        double prob = (double) count/N;
        System.out.println(prob);
    }
}