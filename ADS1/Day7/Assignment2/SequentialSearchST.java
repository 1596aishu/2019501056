/**
 * @author -- Aiswarya
 */

import java.lang.Comparable;
import java.util.*;

/**
 * @param Key key extends Comparable<Key>
 * @param Value
 */
class SequentialSearchST<Key extends Comparable<Key>, Value> {
    Node first; // first Node

    /**
     * Create Node class 
     * which has Key, Value, and Node
     * @param key Key type
     * @param value Value type
     * @param next Node type
     */
    class Node {
        Node next;
        Key key;
        Value value;

        Node(Key key, Value value) { 
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return key + " " + value;
        }
    }

    /**
     * @param key is the key input
     * @param value input value
     * input the key and value to the keys and values
     * Add to the SequentialSearchST. 
     */
    public void put(Key key, Value value) {
        Node node = new Node(key, value);
        if (first == null) {
            first = node; 
            return;
        } 
        Node n = first; 
                                          
        while (n != null) {
            
            if (n.key.compareTo(key) == 0) {
                n.value = value;
                return;
            }
            n = n.next;
        }
        Node old = first; 
        first = new Node(key, value); 
        first.next = old; 
    }

    /**
     * @param y input Node y used to swap
     */
    private  Value exchange(Node y) {
        Node ex = y.next;
        Value value = ex.value;
        y.next = y.next.next;
        Node node = first;
        while (node.next != null) {
            node = node.next;
        }
        node.next = ex;
        ex.next = null;
        return value;
    }

    /**
     * @param key input key
     * compares the given key with thekeys present in it 
      */
    public Value get(Key key) {
        if (key == null) {
            return null;
        }
        if(first.key.compareTo(key) == 0) {
            return exchange(first);
        }
        Node n = first;
        while(n != null) {
            if (n.next.key.compareTo(key) == 0) {
                return exchange(n);
            }
            n = n.next;
        }
        return null;
    }

    /**
     * enqueue's all the keys to the queues and returns Queue.
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<>();
        Node x = first;
        while(x != null) {
            queue.enqueue(x.key);
            x = x.next;
        }
        return queue;
    }
}