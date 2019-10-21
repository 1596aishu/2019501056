/**
 * We'll say that a number is "teen" if it is in the range 13..19 inclusive.
 * Given 2 int values, return true if one or the other is teen, but not both.
 * 
 * Input : loneTeen(13, 99)
 * Output : true
 * 
 * Input : loneTeen(21, 19)
 * Output : true
 * 
 * Input : loneTeen(13, 13)
 * Output : false
 * 
 * @author Siva Sankar and aiswarya
 */

public class LoneTeen {

    /**
     * This method should return true, if either of the two inetegers is a teen.
     * A teen is a number that is in the range of 13..19
     * 
     * @param a the first number as a parameter to the method.
     * @param b the second number as a parameter to the method.
     * 
     * @return true if the either of a or b is a teen and false otherwise.
     */
    public static boolean loneTeen(int a, int b) {
        // Your code goes here....
        if ((a>=10 && a<=20) && !(b >=10 && b<=20))
        {
            return true;
        }
        if ((b>=10 && b<=20) && !(a>=10 && a<=20))
        {
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String args[])
    {
        loneTeen(13, 99);
    }
}