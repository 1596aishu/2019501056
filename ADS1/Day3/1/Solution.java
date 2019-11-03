//@ author aiswarya
/**
 * This sort,sorts the values from its first index comparing with the next index value and swaps if 2nd is small
 * and makes two arrays to the left sorted values and to the right unsorted values
 */
class Solution{
	public int[] sortInsertion(int[] arr){
		int j , temp;
		for (int i =1; i < arr.length; i++) {
			j = i - 1;
			temp = arr[i];
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
		return arr;
	}

	/**
	 * This sort compares the 0th index value with all the other elements iterating the loop
	 * and swaps the 0th value with the minimum value
	 * like wise continues till the end of the length.
	 * @param arr given unsorted array
	 * @return the sorted array.
	 */
	public int[] sortSelection(int[] arr){
		for (int i = 0; i < arr.length-1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			
		}
		//System.out.println(Arrays.toString(arr));
		return arr;
	}
}