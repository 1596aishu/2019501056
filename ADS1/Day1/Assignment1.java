class Assignment1{
    public static int binarySearch(int[] a, int b){
        int low = 0, high = a.length -1;
        while(low<=high){
            int mid = low +(low+high) /2;
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
        int temp = 0, count = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(a[j-1] > a[j])
				{   
				    temp = a[j-1];  
					a[j-1] = a[j];  
					a[j] = temp;  
                }
                int key = -(a[i]+a[j]);	
                binarySearch(a,key);
                if(key!= -1  && a[i]<a[j] && a[j]<a[key])
                    count++;
            }
        }
        System.out.println(count);
    }
}
