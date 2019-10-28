/**
 * 
 */

public class List extends AbstractList {
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
        }
    }
    
    public List subList(int fromIndex, int toIndex) throws InvalidException{
        // TODO
        // Your code goes here.
        if(fromIndex<0){
            throw new InvalidException("fromIndex is less than 0");
        }
        else if(fromIndex==toIndex){
            throw new InvalidException("fromIndex is greater than or equal to toIndex");
        }
        else if(toIndex>getLength()){
            throw new InvalidException("toIndex is greater than size");
        }
        else{
        List l1 = new List();
        for(int i=fromIndex;i<toIndex;i++){
            l1.add(getArray(i));
        }
        return l1;
        }
        //return null;
    }    
}