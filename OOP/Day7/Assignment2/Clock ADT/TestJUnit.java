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

public class TestJUnit {

   @Test
   public void testCase1() {
      Clock clock = new Clock("09:30");
      clock.tic();
      assertEquals("1. ", "09:31", clock.toString());
      clock.toc(29);
      assertEquals("2. ", "10:00", clock.toString());
      clock.toc(120);
      assertEquals("3. ", "12:00", clock.toString());
      clock.toc(61);
      assertEquals("4. ", "13:01", clock.toString());
      clock = new Clock("00:00");
      assertEquals("5. ", "00:00", clock.toString());
      clock.toc(0);
      assertEquals("6. ", "00:00", clock.toString());
      clock.tic();
      assertEquals("7. ", "00:01", clock.toString());
      clock.toc(10);
      assertEquals("8. ", "00:11", clock.toString());
   }

   @Test
   public void testCase2() {
      Clock clock = new Clock("23:59");
      clock.toc(1);
      assertEquals("1. ", "00:00", clock.toString());
      clock.toc(120);
      assertEquals("2. ", "02:00", clock.toString());
      clock.toc(59);
      assertEquals("3. ", "02:59", clock.toString());
      clock.tic();
      assertEquals("4. ", "03:00", clock.toString());
      clock.toc(119);
      assertEquals("5. ", "04:59", clock.toString());
      clock.tic();
      assertEquals("6. ", "05:00", clock.toString());
      clock.toc(12000);
      assertEquals("7. ", "13:00", clock.toString());
      clock.toc(661);
      assertEquals("8. ", "00:01", clock.toString());
      clock.toc(-100);
      assertEquals("9. ", "00:01", clock.toString());
   }

   @Test
   public void testCase3() {
      Clock thisClock = new Clock(10, 20);
      Clock thatClock = new Clock("10:19");
      assertEquals("1. ", false, thisClock.isEarlierThan(thatClock));
      thatClock = new Clock("10:21");
      assertEquals("2.", true, thisClock.isEarlierThan(thatClock));
      thisClock = new Clock("00:00");
      thatClock = new Clock("23:59");
      assertEquals("3.", true, thisClock.isEarlierThan(thatClock));
   }
}