class Solution{
	public static boolean isMinHeap(double[] arr){
		if(arr.length==0) return false;
		for(int i=0;i<arr.length;i++){
			if((2*i)+1<arr.length && (2*i)+2<arr.length){
				if(arr[i]>arr[(2*i)+1] && arr[i]>arr[(2*i)+2]){
					return false;
				}
			}
		}
		return true;
	}
}
