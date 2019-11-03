import java.util.*;
class Solution{
	// public String res = "1 3 5 0 4 2 6";
	// 
	// int[] a = new int[n];
		
	public String Josephus(int n, int m){
		// fill you code Here
		String[] a = new String[n];
		String p ="";
		for(int i = 0;i<n;i++){
			a[i]=Integer.toString(i);
		}
		int count = 1;
		int size = a.length;
		// System.out.print(Arrays.toString(a));
		for(int j = 0;j<n;j++){
			if(count == m){
				p=p+a[j]+", "; 
				for(int k = j; k <size-1;k++){
					// System.out.println(j);
					a[k] = a[k+1];					
					count = 1;
				}
				// resize(size--,a);
				System.out.println(Arrays.toString(a));
				System.out.println(p);
				
			}count++ ;
			if(size == 1){
					break;
				}		
		}
		return "";
	}

		
	private void resize(int cap,int[] a){
		int[] copy = new int[cap];
		for(int i=0;i<cap;i++){
			copy[i]=a[i];
		}
		a=copy;
		// System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args){
		Solution s = new Solution();
		s.Josephus(7,2);
	}
}