/**
 * This acts as an interface (API) for the client.
 * 
 * @author Siva Sankar and aiswarya
 */

public interface ListInterface {
    /**
     * Adds an item to this List.
     */
    public void add(int item);
   
    /**
     * Thid method returns the number of elements in this list.
     * if list is empty, then it returns 0 by default.
     * @return the number of elements in this list.
     */
    public int size();

    /**
     * Returns an item at a particular index from this list.
     */
    public int get(int index) throws InvalidException;

    /**
     * This method returns the index of an item. If the item is not
     * present in the list, then return -1.
     * @param item, to be used to find the index.
     * @return the index of the element if present, -1 otherwise.
     */
    public int indexOf(int item);

    /**
     * This method returns true if the item is present in this list.
     * If the item is not present, then return false.
     * @param item, to be used to find whether it is present in this
     * list.
     * @return true if item is present in this list and false otherwise.
     */
    public boolean contains(int item);
    
    /**
     * This method will removes the element at a particular index.
     * Think of once you remove the element, there will be a empty
     * space.
     * 
     * Now move all the items to the left by one position.
     * 
     * Please see the comemnts in Assignment - 2 for more details 
     * in Polymorphism and Abstract Data Type.
     * 
     * @param item, to be removed from a particular index in this list.
     */
    public void remove(int index) throws InvalidException;

    public void addAll(int[] arr) throws InvalidException;
    
    public int lastIndexOf(int item);

    public int count(int item);

    public List subList(int fromIndex, int toIndex) throws InvalidException;

    public void addAll(List lst) throws InvalidException;

    public void add(int index, int item) throws InvalidException;
}