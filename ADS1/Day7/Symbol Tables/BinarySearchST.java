

class BinarySearchST<Key extends Comparable<Key>, Value>{

    public void put(Key k, Value v){
        if(!symbolTable.contains(k)) symbolTable.put(k, 1);
        else symbolTable.put(k, v);
    }

    public Value get(Key key){
        if(isEmpty()) return null;
        int i = rank(key);
        if(i<N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }

    private int rank(Key key){
        int low = 0, high = N-1;
        while(low<=high){
            int mid = low+high /2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp<0) high = mid-1;
            else if(cmp>0) low = mid+1;
            else return mid;
        }
    }
    public boolean contains(Key key){
        return get(key)!=null;
    }
    public void delete(Key key){
        put(key, null);
    }
    public boolean isEmpty(){
        return symbolTable.length == 0;
    }
    public Key max(){
        String max="";
        symbolTable.put(max,0);
        for(String word : symbolTable.keys()){
            if(symbolTable.get(word)>symbolTable.get(max)){
                max = word;
            }
        }
        return symbolTable.get(max);
    }
}

