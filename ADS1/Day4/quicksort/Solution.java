// @ author aiswarya

class Solution{
	public static int[] quickSort(int[] arr){
		// fill you code Here
		int n = arr.length;
		Solution q = new Solution();
		q.sort(arr, 0 ,n-1);
		return arr;

}
/**
 * this method partitions the given array based on the pivot elemet
 * @param arr the integer array
 * @param low lower index
 * @param high higher index
 * @return the index of i or j indexes
 */

	int partition(int arr[], int low, int high){

		int pivot = arr[high];
		int i = (low - 1);
		for(int j = low; j<high;j++){
			if(arr[j] < pivot){

				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

			}

		}

		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return i+1;


	}
	/**
	 * this method sorts the values by partitioning the array  by giving the lesser values to the left
	 * and higher values to the right
	 * @param arr array of integers
	 * @param low lower index
	 * @param high higher index
	 */

	void sort(int arr[], int low, int high){

		if(low < high){
			int par = partition(arr, low, high);
			sort(arr, low, par-1);
			sort(arr, par+1,high);

		}
	}

	
}





    