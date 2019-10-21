/**
 * We'll say that a number is "teen" if it is in the range 13..19 inclusive. 
 * Given 3 int values, return true if 1 or more of them are teen.
 * 
 * Input : hasTeen(13, 20, 10)
 * Output : true
 * 
 * Input : hasTeen(20, 19, 10)
 * Output : true
 * 
 * Input : hasTeen(20, 10, 13)
 * Output : true
 * 
 * @author Siva Sankar and aiswarya
 */

 public class HasTeen {

    /**
     * 
     * We'll say that a number is "teen" if it is in the range 13..19 inclusive. 
     * 
     * @param a the first numebr as parameter to the method
     * @param b the second numebr as parameter to the method
     * @param c the third numebr as parameter to the method
     * 
     * @return return true if 1 or more of them are teen, otherwise false
     * 
     */
    public static boolean hasTeen(int a, int b, int c) {
        // Your code goes here....
        if (13 <= a && a<= 19) 
        {
            return true;
        }
        else
        { 
            if (13<=b && b<=19)
            {
                return true;
            }
            if (13<=c && c<=19)
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String args[])
    {
        boolean teen = hasTeen(13, 20, 10);
        System.out.println(teen);

    }
}