import java.util.Arrays;
class OrderedList extends AbstractList {
    public void add(int item) {
        if (size == intList.length){
            this.resize();
        }
        intList[size()] = item;
        size += 1;
        Arrays.sort(intList);
    }
    public int indexOf(int item) {
        int low = 0;
        int high = size-1;
        int mid = 0;
        for (int i=0; i<size/2; i++) {
            mid = (low+high)/2;
            if (intList[mid] == item){
                return mid;
            }else if (intList[mid] > item) {
                high = mid;
            }else if (intList[mid] < item) {
                low = mid;
            }
        } return -1;
    }


}