import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  
 *  @author aiswarya
 *  Complexity is NlogN
 *  @param <Key> the generic type of key on this priority queue
 */
public class priorityQ<Key> implements Iterable<Key> {
    private Key[] pq;                    // store items at indices 1 to n
    private int n;                       // number of items on priority queue
    private Comparator<Key> comparator;  // optional comparator

    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param  Capacity the initial capacity of this priority queue
     */
    public priorityQ(int Capacity) {
        pq = (Key[]) new Object[Capacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue.
     */
    public priorityQ() {
        this(1);
    }

    /**
     * Initializes an empty priority queue with the given initial capacity,
     * using the given comparator.
     *
     * @param  Capacity the initial capacity of this priority queue
     * @param  comparator the order in which to compare the keys
     */
    public priorityQ(int Capacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[Capacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue using the given comparator.
     *
     * @param  comparator the order in which to compare the keys
     */
    public priorityQ(Comparator<Key> comparator) {
        this(1, comparator);
    }

    /**
     * Initializes a priority queue from the array of keys.
     *
     * @param  keys the array of keys
     */
    public priorityQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i+1] = keys[i];
        for (int k = n/2; k >= 1; k--)
            sink(k);
        assert isMinHeap();
    }

    /**
     * Returns true if this priority queue is empty.
     *
     * @return true if this priority queue is empty;
     *         else false
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }

    /**
     * @return a smallest key on this priority queue
     */
    public Key min() {
        return pq[1];
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /**
     * Adds a new key to this priority queue.
     *
     * @param  x the key to add to this priority queue
     */
    public void insert(Key j) {
        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        pq[++n] = j;
        swim(n);
        assert isMinHeap();
        // System.out.println(Arrays.toString(pq));
    }

    /**
     * @return a smallest key on this priority queue.
     */
    public Key delMin() {
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;     // to avoid loiterig and help with garbage collection
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        // System.out.println(min);
        assert isMinHeap();
        // System.out.println(Arrays.toString(pq));
        return min;
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    private boolean isMinHeap() {
        for (int i = 1; i <= n; i++) {
            if (pq[i] == null) return false;
        }
        for (int i = n+1; i < pq.length; i++) {
            if (pq[i] != null) return false;
        }
        if (pq[0] != null) return false;
        return isMinHeapOrdered(1);
    }

    private boolean isMinHeapOrdered(int k) {
        if (k > n) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= n && greater(k, left))  return false;
        if (right <= n && greater(k, right)) return false;
        return isMinHeapOrdered(left) && isMinHeapOrdered(right);
    }

    /**
     *
     * @return an iterator that iterates over the keys in descending order
     */
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {

        // create a new pq
        private priorityQ<Key> copy;

        // add all items to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            if (comparator == null) 
            copy = new priorityQ<Key>(size());
            else                  
              copy = new priorityQ<Key>(size(), comparator);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }
  
    public static void main(String[] args){
        priorityQ<Integer> p = new priorityQ<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the N value: ");
        int N = sc.nextInt();
        System.out.println("Enter the k value: ");
        int k = sc.nextInt();
        for(int i=0;i<N;i++){
            p.insert(sc.nextInt());
        }
        for(int i = 0; i<N-k;i++){
            p.delMin();
        }
        System.out.println("K largest elements are: ");
        for(int s: p){
            System.out.print(s+" ");
        }
	}
 }

