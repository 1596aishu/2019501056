import java.util.Arrays;
class Assignment2{
    public static void main(String[] args){
        int[] a = {31, -40, -20, -10, 40, 4, 10, 5};
        int[] b = {55, 30, -10, 0, 38, 6, 50, 40};
        int i=0;
        int j=0;
        Arrays.sort(a);
        Arrays.sort(b);
        for(int x =0;x<(a.length+b.length);x++){
            if(i<a.length && j<b.length){
                if(a[i]<b[j]){
                    System.out.println(a[i]);
                    i++;
                }
                else if(a[i]>b[j]){
                    System.out.println(b[j]);
                    j++;
                }
                else if(a[i]==b[j]){
                    System.out.println(a[i]);
                    System.out.println(b[j]);
                    i++;
                    j++;
                    x++;
                }
            }
            else{
                if(i>a.length-1) {
                    System.out.println(b[j]);
                    j++;
                }
                else if(j>b.length-1){
                     System.out.println(a[i]);
                     i++;
                }
                // System.out.print(a[i]);
            }
            
        }
    }
}