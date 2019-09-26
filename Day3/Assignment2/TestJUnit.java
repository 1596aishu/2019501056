/**
 * This is JUnit that tests the frontTimes method in FrontTimes class.
 * This contains 7 testcases.
 * 
 * Please don't run this file.
 * 
 * You can add your own test cases to this file by just copy and 
 * paste the last three lines of the code (TestCase7).
 * 
 * @author: Siva Sankar
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {

   @Test
   public void testCase1() {
	   assertEquals("ChoCho", FrontTimes.frontTimes("Chocolate", 2));
   }

   @Test
   public void testCase2() {
      assertEquals("ChoChoCho", FrontTimes.frontTimes("Chocolate", 3));
   }

   @Test
   public void testCase3() {
      assertEquals("AbcAbcAbc", FrontTimes.frontTimes("Abc", 3));
   }

   @Test
   public void testCase4() {
      assertEquals("AbAbAbAb", FrontTimes.frontTimes("Ab", 4));
   }

   @Test
   public void testCase5() {
      assertEquals("AAAA", FrontTimes.frontTimes("A", 4));
   }

   @Test
   public void testCase6() {
      assertEquals("", FrontTimes.frontTimes("", 4));
   }

   @Test
   public void testCase7() {
      assertEquals("", FrontTimes.frontTimes("Abc", 0));
   }
}