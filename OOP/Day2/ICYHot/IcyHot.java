/**
 * Given two temperatures, return true if one is less than 0 and the other 
 * is greater than 100.
 * 
 * Input : icyHot(120, -1)
 * Output : true
 * 
 * Input : icyHot(-1, 120)
 * Output : true
 * 
 * Input : icyHot(2, 120)
 * Output : false
 * 
 * @author Siva Sankar and aiswarya
 */

 public class IcyHot {

    /**
     * This method should return true if one is less than 0 and the other is greater
     * than 100
     * 
     * @param temp1 represents temparature1
     * @param temp2 represents temparature2
     * 
     * @return true if one is less than 0 and the other is greater than 0, 
     * false otherwise
     */
    public static boolean icyHot(int temp1, int temp2) {
        // Your code goes here...
        if ((temp1>0 && temp2<0) || (temp1<0 && temp2>0)){
            return true;
        }else {
            return false;
        }
    }
}