import java.lang.Comparable;
import java.util.*;
class quicksort{
    public int partition(Comparable[] a, int low, int high){
        int i = low, j = high+1;
        while(true){
            while(less(a[++i],a[low])){
                if(i == high) break;}
            while(less(a[low],a[--j])){
                if(j == low) break;}
            if(i>=j) break;
            swap(a,i,j);
        } 
        swap(a,low,j);
        return j;
    }
    public boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }
    public void swap(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public void sort(Comparable[] a, int low, int high){
        if(high<=low) return;
        int x = partition(a,low,high);
        sort(a,low,x-1);
        sort(a,x+1,high);
    }
    public static void main(String[] args){
        quicksort q = new quicksort();
        Comparable[] a = {2,3,5,9,7,6,4,1,8};
        int low = (int)(0);
        int high = (int)(a.length-1);
        q.sort(a,low,high);
        System.out.println("Array:"+Arrays.toString(a));

    }
}
