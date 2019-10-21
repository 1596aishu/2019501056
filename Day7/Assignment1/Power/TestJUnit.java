/**
 * This is JUnit that tests the methods of the Clock.
 * This contains 2 testcases.
 * 
 * Please don't run this file.
 * You can add your own test cases to this file by just copy and 
 * paste the last three lines of the code (TestCase2).
 * 
 * @author: Siva Sankar
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.beans.Transient;

public class TestJUnit {

   @Test
   public void testCase1() {
      assertEquals("1.", 625, Power.pow(25, 2));
      assertEquals("2.", 0, Power.pow(0, 1));
      assertEquals("3.", 1, Power.pow(1, 0));
      assertEquals("4.", 25, Power.pow(5, 2));
      assertEquals("5.", 1024, Power.pow(2, 10));
      assertEquals("6.", 625, Power.pow(5, 4));
      assertEquals("7.", 3125, Power.pow(5, 5));
      assertEquals("8.", 9765625, Power.pow(5, 10));
      assertEquals("9.", 95367431640625L, Power.pow(5, 20));
      assertEquals("10.", 10000000000L, Power.pow(10, 10));
   }

   @Test
   public void testCase2() {
      assertEquals("1.", 650.25, Power.pow(25.5f, 2), 0.001);
      assertEquals("2.", 0, Power.pow(0, 1));
      assertEquals("3.", 1.44, Power.pow(1.2f, 2), 0.001);
      assertEquals("4.", 1.5311470590058303E7, Power.pow(5.23f, 10), 0.001);
      assertEquals("5.", 1024, Power.pow(2, 10));
      assertEquals("6.", 915.0625, Power.pow(5.5f, 4), 0.01);
      assertEquals("7.", 1.0, Power.pow(5.023f, 0), 0.01);
      assertEquals("8.", 1.999396097091676, Power.pow(1.414f, 2),0.01);
      assertEquals("9.", 291512.30887536675, Power.pow(1.876f, 20), 0.01);
      assertEquals("10.", 1.0, Power.pow(5.023f, 0), 0.01);
   }  
}