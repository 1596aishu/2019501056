/**
 * Given 2 int values, return true if one is negative and one is positive. 
 * Except if the parameter "negative" is true, then return true only 
 * if both are negative.
 * 
 * Input : posNeg(1, -1, false)
 * Output : true
 * 
 * Input : posNeg(-4, -5, false)
 * Output : false
 * 
 * @author Siva Sankar and aiswarya
 */

 public class PositiveNegative {

    /**
     * This method should return true if one is negative and one is positive.
     * @param a, the first parameter which is an int to this method.
     * @param b, the second parameter which is an int to this method.
     * @param negative, the third parameter which is a boolean to this method.
     * 
     * @return true if one is negative and the other is positive except if parameter
     * negative is true, then return true if both a and b are negative.
     */
    public static boolean posNeg(int a, int b, boolean negative) {
        // Your code goes here....
        if (negative){
            if (a < 0 && b < 0){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if (a < 0 && b < 0){
                return false;
            }
            else{
                return true;
            }
        }
    }
    public static void main(String args[]){
        boolean p = posNeg(1, -1, false);
        System.out.println(p);
        boolean p1 = posNeg(-4, -5, false);
        System.out.println(p1);
    }
 }