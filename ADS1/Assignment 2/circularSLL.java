/*
*   @author Aiswarya
*/

import java.util.*;

public class circularSLL<Item> implements Iterable<Item> {
        // beginning of queue
    private Node<Item> last;
    private int n;               // number of elements in queue

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty queue.
     */
    public circularSLL() {
        last = null;
        n = 0;
    }

    /**
     * Returns true if this queue is empty.
     *
     * @return true if this queue is empty else false otherwise
     */
    public boolean isEmpty() {
        return last == null;
    }

    /**
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }

    /**
     * @param  item the item to add
     * Complexity: N
     */
    // public void enqueue(Item item) {
    //     Node<Item> newlast = new Node<Item>();
    //     if(isEmpty()) first = newlast;
    //     else {
    //         Node<Item> current = last.next;
    //         while(current.next!=first){
    //             current= current.next;
    //         }
    //         current.next = newlast;
    //     }
    //     newlast.item = item;
    //     newlast.next = first;
    //     n++;  
    //     System.out.println(newlast.item);  
    // }

    /**
     * @param  item the item to add
     * Complexity: Constant
     */
    public void enqueue(Item item) {
        Node<Item> newlast = new Node<Item>();
        newlast.item = item;
        if(isEmpty()) { 
            last = newlast;
            newlast.next = last;
        }
        else {
            newlast.next = last.next;
            last.next = newlast;
        }
        last = newlast;
        n++;  
        System.out.println(last.item);
    }

    /**
     * @return the item on this queue that was added at the beginning
     * @throws NoSuchElementException if this queue is empty
     */
    public Item dequeue() {
        if(isEmpty()) throw new NoSuchElementException();
        Item item = last.next.item;
        last.next = last.next.next;
        n--;
        return item;
    } 

    /**
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator(last);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = last;
        }

        public boolean hasNext() { return current != null; }
        public void remove() { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

    public static void main(String[] args){
        circularSLL<Integer> cl = new circularSLL<Integer>();
        cl.enqueue(1);
        cl.enqueue(2);
        cl.enqueue(3);
        cl.enqueue(4);
        System.out.println("Deleted number: "+cl.dequeue());
        System.out.println("Deleted number: "+cl.dequeue());
        cl.enqueue(5);
        System.out.println("Deleted number: "+cl.dequeue());
        System.out.println("Deleted number: "+cl.dequeue());
        System.out.println("Deleted number: "+cl.dequeue());
    }
}

/*
*   The comparison between Queue implementation using arrays and linked lists.
*
* Queue implementation using arrays generates the following complexities:
*Time Complexity of Enqueue : O(1)
*   In enqueue, the insertion happens from the rear end directly.
*Time Complexity of Dequeue : O(n)
*   In dequeue, the deletion happens from the front, but later we need to shift the other elements to fill the positions.
*Hence, we left shift all the elements and reduce the size by 1.
*We can implement both enqueue and dequeue operations in O(1) time. 
*To achieve this, we use Linked List Implementation of Queue.
*Time Complexity of Enqueue : O(1)
*   In enqueue, the insertion happens from rear end and here we connected the new element to the last element. 
*   And the newlast element to the first element.
*Time Complexity of Dequeue : O(1)
*   In dequeue, the deletion happens from the front and here we connected the second element with the last element.
*/