/**
 * This is JUnit that tests the stringTimes method in StringTimes class.
 * This contains 10 testcases.
 * 
 * Please don't run this file.
 * You can add your own test cases to this file by just copy and 
 * paste the last three lines of the code (TestCase10).
 * 
 * @author: Siva Sankar
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {

   @Test
   public void testCase1() {
      assertEquals("HiHi", StringTimes.stringTimes("Hi", 2));
   }

   @Test
   public void testCase2() {
      assertEquals("HiHiHi", StringTimes.stringTimes("Hi", 3));
   }

   @Test
   public void testCase3() {
      assertEquals("Hi", StringTimes.stringTimes("Hi", 1));
   }

   @Test
   public void testCase4() {
      assertEquals("", StringTimes.stringTimes("Hi", 0));
   }

   @Test
   public void testCase5() {
      assertEquals("HiHiHiHiHi", StringTimes.stringTimes("Hi", 5));
   }

   @Test
   public void testCase6() {
      assertEquals("Oh Boy!Oh Boy!", StringTimes.stringTimes("Oh Boy!", 2));
   }

   @Test
   public void testCase7() {
      assertEquals("xxxx", StringTimes.stringTimes("x", 4));
   }

   @Test
   public void testCase8() {
      assertEquals("", StringTimes.stringTimes("", 4));
   }
   
   @Test
   public void testCase9() {
      assertEquals("codecode", StringTimes.stringTimes("code", 2));
   }

   @Test
   public void testCase10() {
      assertEquals("codecodecode", StringTimes.stringTimes("code", 3));
   }
}