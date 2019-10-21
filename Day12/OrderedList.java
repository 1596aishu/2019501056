/**
 * 
 */

public class OrderedList extends AbstractList {
    /*
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     * 
     * The method returns void (nothing)
     */
    public void add(int item){
        //Inserts the specified element at the end of the list.
        //  Your code goes here.....
        if(getLength()<getSize()){
            setArray(getLength(),item);
            setLength(getLength()+1);
        }
        else{
            int arr1[] = new int[2*getSize()];
            setSize(getSize()*2);
            for(int i=0;i<getLength();i++){
                arr1[i]=getArray(i);
            }
        setNewArray(arr1);
        setArray(getLength(),item);
        setLength(getLength()+1);
        
        for (int i = 0; i < getLength(); i++) {
            int temp;
            if (getArray(i) > getArray(i+1)) {
                temp = getArray(i);
                setArray(i,getArray(i+1));
                setArray(i+1,temp);
            }
        }

    }
    }


public int rank(int item) {
    int lo = 0, hi = getLength()-1; 
    while (lo <= hi) { 
        int mid = lo + (hi - lo) / 2;
        if      (item < getArray(hi)) hi = mid - 1; 
        else if (item > getArray(lo)) lo = mid + 1; 
        else return mid; 
    } 
    return lo;
}
}