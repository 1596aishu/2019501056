/**
 * Given "a" an integer or float value, and b as an integer value, 
 * Find a power b.
 *
 * @author Siva Sankar
 */

import java.util.*;
public class Power {
    /**
     * This method finds a^b where both a and b are integers.
     * @param  a, the base
     * @param  b, the exponential
     * @return a^b which is a long value.
     */
     public static long pow(int a, int b) {
        long power = 0;
        power = (long)Math.pow(a,b);
        return power;
     }

     /**
     * This method finds a^b where both variable a is a double 
     * and b is an integer.
     * @param  a, the base
     * @param  b, the exponential
     * @return a^b which is a long value.
     */
     public static double pow(float a, int b) {
      double power = 0;
      power = Math.pow(a,b);
      return power;
     }
 }