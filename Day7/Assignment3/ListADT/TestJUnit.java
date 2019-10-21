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
      List l = new List();
      l.add(5);
      l.add(-1);
      assertEquals("1. ", 2, l.size());
      assertEquals("2. ", "[5,-1]", l.toString());
      l.add(0);
      l.add(99);
      assertEquals("3. ", "[5,-1,0,99]", l.toString());
      l.remove(1);
      assertEquals("4. ", "[5,0,99]", l.toString());
      assertEquals("5. ", 3, l.size());
      assertEquals("6. ", "[5,0,99]", l.toString());
      assertEquals("7. ", -1, l.indexOf(-1));
      assertEquals("8. ", 99, l.get(2));
      assertEquals("9. ", true, l.contains(5));
   }

   @Test
   public void testCase2() {
      List lst = new List();
      lst.add(8);
      lst.add(12);
      lst.add(97);
      assertEquals("1. ", "[8,12,97]", lst.toString());
      lst.add(11);
      assertEquals("2. ", 4, lst.size());
      lst.remove(12);
      assertEquals("3. ", "[8,12,97,11]", lst.toString());
      assertEquals("4. ", 4, lst.size());
      assertEquals("5. ", 0, lst.indexOf(8));
      assertEquals("6. ", 97, lst.get(2));
      assertEquals("7. ", -1, lst.get(12));
      assertEquals("8. ", -1, lst.get(5));
      assertEquals("9. ", -1, lst.get(50));
      assertEquals("9. ", true, lst.contains(97));
      lst.remove(1);
      assertEquals("10. ", false, lst.contains(12));
   }
}