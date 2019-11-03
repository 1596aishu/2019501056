//@auther aiswarya

/**
	 
	 * @param a is the integer array
	 * @param b is the element to be searched
	 * @param low lower index
	 * @param mid middle index
	 * @param high higher index
	 */
	

import java.util.Arrays;
class Assignment1{
    public static int binarySearch(int[] a, int b){
        int low = 0, high = a.length -1;
        while(low<=high){
            int mid = (low + high) /2;
            if(b<a[mid]){
                high = mid-1;
            }
            else{
                if(b>a[mid]){
                    low = mid+1;
                }
                else{
                    return mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int a[] = {30, -40, -20, -10, 40, 0, 10, 5};
        int n = a.length;
        Arrays.sort(a);
        for(int k = 0;k<n;k++)
            System.out.print(a[k]+" , ");
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int key = -(a[i] + a[j]);
                int x = binarySearch(a, key);
                if (x != -1 && a[i] < a[j] && a[j] < a[x]) {
                    count += 1;
                }
            }
        }
        System.out.println("The number of pairs are : "+ count);
    }
}

