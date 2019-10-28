import java.util.Arrays;
abstract class AbstractList implements ListInterface {
    int[] intList;
    int size;
    public AbstractList(){
        size = 0;
        intList = new int[10];
    }
    public AbstractList(int capacity) {
        size = 0;
        intList = new int[capacity];
    }
    public void add(int item){}
    public int size() {
        return size;
    }
    public void resize() {
        intList = Arrays.copyOf(intList, intList.length*2);
    }
    public int get(int index) {
        if (index<size && index>=0) {
            return intList[index];}
            else {
                return -1;
            }
    }
    public abstract int indexOf(int item);
    public boolean contains(int item) {
        for (int i=0; i<size; i++) {
            if (intList[i] == item) {
                return true;
            }
        } return false;
    }
    public void remove(int index) {
        // write the logic for remove here.
        // Think about what to do to the size variable.
        if (index < size){
            for (int i = index; i<size; i++) {
                intList[i] = intList[i+1];
            }
            intList[size-1] = 0; 
            size -= 1;
        }
    }
    public String toString() {
        if(size == 0)
            return "";
        String str = "[";
        int i = 0;
        for(i = 0; i < size - 1; i++) {
            str = str + intList[i] + ",";
        }
        str = str + intList[i] + "]";
        return str;
    }
}