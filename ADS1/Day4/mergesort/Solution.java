import java.lang.Comparable;
import java.util.*;
// @author aiswarya

import java.util.Arrays;
class Solutions{
	public static String[] mergeSort(String[] arr){
		// fill you code Here
		String[] arr1 = new String[arr.length];
			sort(arr,arr1,0,arr.length-1);
			return arr;
	}

	/**
	 
	 * @param a is the String array
	 * @param b is the array which is the copy of origal array
	 * @param low lower index
	 * @param mid middle index
	 * @param high higher index
	 */
	
    public static void merge(String[] a, String [] b, int low,int mid, int high){
		for(int k = low ; k <= high ; k++){
			b[k] = a[k];
		}
		 int i= low, j = mid+1;
		 for( int k= low; k <= high ; k++){
			 if( i > mid) a[k] = b[j++];
			 else if(j > high) a[k] = b[i++];
			 else if(b[j].compareTo(b[i] ) < 0) // compareTo is used to compare the two values
				 a[k] = b[j++];
			 else a[k] = b[i++];
		 }  
	}	
	/**
	 * this method sorts the array based on the low, mid and high values
	 * @param a is the original String array
	 * @param b copy of origal array
	 * @param low lower index if the of aux array
	 * @param high higher index of the aux array
	 */
	public static void sort(String[] a,String[] b, int low, int high){
        if(high<=low) return;
        int mid = (low+high)/2;
        sort(a,b,low,mid);
        sort(a,b,mid+1,high);
        merge(a,b,low,mid,high);
    }
	
}