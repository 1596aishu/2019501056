import java.util.*;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements in queue

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    }
    // construct an empty deque
    public RandomizedQueue() {
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

    // add the item
    public void enqueue(Item item) {
        Node<Item> newitem = new Node<Item>();
        if(isEmpty()) first = newitem;
        else last.next = newitem;
        newitem.item = item;
        newitem.next = null;
        newitem.prev = last;
        last = newitem;
        n++;
        // System.out.println(last.item);
    }

    // remove and return a random item
    public Item dequeue() {
        int i = 0;
        int x = random(0,n);
        Node<Item> current = first;
        if(i != x) {
            current = current.next;
            i++;
        }
        Item item = current.item;
        current.prev.next = null;
        n--;
        if (isEmpty()) last = null;
        // System.out.println(item);
        return item;
    }

    //generates the random index
    private int random(int max, int min) {
        int num = (int)(Math.random()*(max-min) + min);
        // System.out.println(num);
        return num;
    }
    // return a random item (but do not remove it)
    public Item sample() {
        Item item = first.item;
        return item;
    }

    // Method for forward traversal
    private void displayForward() {
        Node<Item> current = first;
        while(current != null) {
            for(int i=0; i<n;i++) {
                // System.out.print(current.item + " ");
                current = current.next;
            }        
        }
    }
    
    // // Method to traverse and display all nodes
    // public void displayBackward(){
    //     Node<Item> current = last;
    //     while(current != first){
    //         for(int i=0; i<n;i++){
    //             System.out.print(current.item + " ");
    //             current = current.prev;
    //         }        
    //     }
    // }

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
        RandomizedQueue<Integer> deque = new RandomizedQueue<Integer>();
        deque.enqueue(2);  
        deque.enqueue(1);
        deque.enqueue(3);
        deque.enqueue(4);
        System.out.println(deque.dequeue());
        deque.displayForward();
        // deque.displayBackward();
    }

}