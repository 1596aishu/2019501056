import java.util.*;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements in queue

    
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    }
    // construct an empty deque
    public Deque() {
        first = null;
        last  = null;
        n = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if(item == null) { throw new IllegalArgumentException("null arguement"); }
        Node<Item> newfirst = new Node<Item>();
        if(isEmpty()) last = newfirst;
        else first.prev = newfirst;
        newfirst.item = item;
        newfirst.next = first;
        first = newfirst;
        n++;
        // System.out.println(first.item);       
    }

    // add the item to the back
    public void addLast(Item item) {
        Node<Item> newlast = new Node<Item>();
        if(isEmpty()) first = newlast;
        else {
            last.next = newlast;
            newlast.item = item;
            newlast.next = null;
            newlast.prev = last;
        }
        last = newlast;
        n++;  
        // System.out.println(last.item);  
    }

    // remove and return the item from the front
    public Item removeFirst() {
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        // System.out.println(item);
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        Item item = last.item;
        last.prev.next = null;        
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        // System.out.println(item);
        return item;
    }

    // Method for forward traversal
    private void displayForward() {
        Node<Item> current = first;
        while(current != null) {
            for(int i = 0; i < n; i++) {
                // System.out.print(current.item + " ");
                current = current.next;
            }        
        }
    }
    
    // Method to traverse and display all nodes
    private void displayBackward() {
        Node<Item> current = last;
        while(current != null) {
            for(int i = 0; i < n; i++) {
                // System.out.print(current.item + " ");
                current = current.prev;
            }        
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new QIterator(first);  
    }

    private class QIterator implements Iterator<Item> {
    
        private Node<Item> current;

        public QIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext(){
            return current != null;
        }
        public void remove(){
            throw new UnsupportedOperationException();  
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(2);  
        deque.addFirst(1);
        deque.addLast(3);
        deque.addLast(4);
        deque.displayForward();
        deque.displayBackward();
        deque.removeFirst();
        deque.removeLast();
        deque.displayForward();
    }

}