/**
 * Return true if the given non-negative number is a multiple of 3 or a multiple of 5.
 * Hint: Use the % "mod" operator.
 * 
 * Input : or35(3)
 * Output : true
 * 
 * Input : or35(10)
 * Output : true
 * 
 * Input : or35(11)
 * Output : false
 * 
 * @author Siva Sankar and aiswarya
 */

public class MultiplesOfThreeFive {
    /**
     * This method returns true if the given n is multiple of 3 or 5.
     * @param n the non-negative integer.
     * @return true if n is divisible by 3 or 5 otherwise false.
     */
    public static boolean or35(int n) {
        // Your code goes here...
        if (n % 3 == 0 || n % 5 ==0){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String args[])
    {
        boolean or = or35(3);
        System.out.println(or);
        boolean or1 = or35(11);
        System.out.println(or1); 
    }
}