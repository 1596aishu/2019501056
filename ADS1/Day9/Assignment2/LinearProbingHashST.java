public class LinearProbingHashST<Key, Value>{
    private static final int CAPACITY = 4;
    public int n;           
    public int m;           
    public Key[] keys;      
    public Value[] vals; 
    public LinearProbingHashST(){
        this(CAPACITY);
    }
    public LinearProbingHashST(int capacity){
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
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
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
        LinearProbingHashST hash = new LinearProbingHashST();
        hash.put("xyz", 12);
        hash.put("abc", 15);
        System.out.println(hash.get("cde"));
        System.out.println(hash.get("abc"));
    }
}