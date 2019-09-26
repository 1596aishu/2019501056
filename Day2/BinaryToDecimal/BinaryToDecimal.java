/**
 * Given a binary string that contains a sequence of 1's and 0's, returns an
 * equivalent to the decimal value in integer form.
 * 
 * Input : 1010
 * Output : 10
 * 
 * Input : 000000000000001010
 * Output : 10
 * 
 * @author Siva Sankar
 */

public class BinaryToDecimal {

    /**
     * This method reads in a Binary String and returns the equivalent to the
     * decimal value of the binary string.
     * @param s, the binary string that contains only sequence of 1's and 0's.
     * @return the decimal number n of the binary string.
     */
    public static int binaryToDecimal(String s) {
        int sum = 0;
        int power = 0;
        for(int i =s.length()-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                sum = sum+ (int)Math.pow(2,power);
            }
            power++;
        }
        return sum;
    }
}