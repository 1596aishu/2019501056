/**
 * Given n, find the absolute value of n.
 * 
 * Input : abs(-1)
 * Output : 1
 * 
 * Input : abs(0)
 * Output : 0
 * 
 * @author Siva Sankar
 */

public class AbsoluteNumber {

    /**
     * This method returns the absolute number of the given n
     * @param n, the integer
     * @return absolute value of n
     */
    public static int abs(int n) {
        // Your code goes here....
        if (n<0){
            System.out.println("Absolute value: "+ n * (-1));
            return n * (-1);
        }
        else{
            System.out.println("Absolute value: "+ n);
            return n;
        }
    }
    public static void main(String args[])
    {
        abs(-2147483647);
        abs(0);
    }
}