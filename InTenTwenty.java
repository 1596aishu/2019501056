/**
 * Given 2 int values, return true if either of them is in the range 10..20 inclusive.
 * 
 * Input : in1020(12, 99)
 * Output : true
 * 
 * Input : in1020(21, 12)
 * Output : true
 * 
 * Input : in1020(8, 99)
 * Output : false
 * 
 * @author Siva Sankar
 */

 public class InTenTwenty {

    /**
     * This method should return true if either of the tow numbers as parameters are in the
     * range of 10..20 inclusive, false otherwise.
     * 
     * @param a, the first integer as parameter to the method.
     * @param b, the second integer as parameter to the method.
     * 
     * @return true if either of them is in the range of 10..20 inclusive and 
     * false otherwise.
     */
    public static boolean in1020(int a, int b) {
        // Your code goes here....
        if ((a>=10 && a<=20) || (b>=10 && b<=20))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void main(String args[])
    {
        boolean Ten20 = in1020(21, 12);
        System.out.println(Ten20);
    }
}