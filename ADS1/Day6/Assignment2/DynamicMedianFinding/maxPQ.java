public class maxPQ<Key extends Comparable<Key>>{
    private Key[] pq;
    private int N;
    public maxPQ(int capacity){
        pq = (Key[]) new comparable[comparable+1];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public void insert(Key key){
        pq[++N] = key;
        swim(N);
    }
    public Key delMax(){
        Key max = pq[1];
        swap(1,N--);
        sink(1);
        pq[N+1] = null;
        return max;
    }
    private void swim(int k){
        while(k>1 && less(k/2,k)){
            swap(k,k/2);
            k = k/2;
        }
    }
    private void sink(int k){
        while(2*k<=N){
            int j = 2*k;
            if(j<N && less(j,j+1)) j++;
            if(!less(k,j)) break;
            swap(k,j);
            k = j;
        }
    }
    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j])<0;
    }
    private void swap(int i, int j){
        Key k = pq[i];
        pq[i] = pq[j];
        pq[j] = k;
    }
}