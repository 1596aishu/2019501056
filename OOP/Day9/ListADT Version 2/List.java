class List extends AbstractList {
    public void add(int item) {
        if (size == intList.length){
            this.resize();
        }
        intList[this.size()] = item;
        size += 1;
        
    }
    public int indexOf(int item) {
        for (int i=0; i<size; i++) {
            if (intList[i] == item) {
                return i;
            }
        } return -1;
    }
}