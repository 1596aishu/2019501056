import java.util.*;

public class Fpair{
    /*
    * sort method, checks the min and max elements of the array.
    * displays the min-max pair. 
    * Time complexity : N (worst case).  
    */
    public static void sort(double[] a, int N){
        double max = a[N-1]; 
        double min = a[0];
        for(int i = 0; i<a.length;i++){
            if(a[i]<min) min = a[i];
            if(a[i]>max) max = a[i];
        }
        System.out.println("max: "+max+" min: "+min);
    }

    /*
    * The size and array are accepted dynamically from the user.
    * sort method is called.
    */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size: ");
        int N = sc.nextInt();
        System.out.println("Enter the array: ");
        double a[] = new double[N];
        for(int i = 0; i<N;i++){
            a[i] = sc.nextDouble();
        }
        sort(a,N);
    } 
}