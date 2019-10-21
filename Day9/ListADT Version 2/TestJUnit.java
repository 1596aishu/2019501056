 /**
 * This is JUnit that tests the methods of the Clock.
 * This contains 2 testcases.
 * 
 * Please don't run this file.
 * You can add your own test cases to this file by just copy and 
 * paste the last three lines of the code (TestCase2).
 * 
 * @author Siva Sankar
 * @author Jagan
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {

   @Test
   public void testCase1() {
      System.out.println("TestCase for Add method in Lists.");
      List lst = new List();
      lst.add(5);
      assertEquals("1. List Object", "[5]", lst.toString());

      AbstractList lst1 = new List();
      for (int i = 0; i < 20; i++) {
         lst1.add(i);
      }
      assertEquals("2. List Object through abstract class", "[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19]", lst1.toString());
      
      ListInterface lst2 = new List();
      for (int i = 0; i < 20; i++)
         lst2.add(i);
      assertEquals("3. List Object through interface", "[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19]", lst2.toString());
   }

   @Test
   public void testCase4() {
      System.out.println("TestCase for Size method in Lists.");
      List lst = new List();

      assertEquals("0. List Object", "0", "" + lst.size());
      lst.add(5);
      int[] arr = {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9};
      for (int i = 0; i < arr.length; i++)
         lst.add(arr[i]);
      assertEquals("1. List Object", "46", "" + lst.size());

      AbstractList lst1 = new List();
      lst1.add(6);
      for (int i = 0; i < arr.length; i++)
         lst1.add(arr[i]);
      assertEquals("2. List Object through abstract class", "46", "" + lst1.size());

      ListInterface lst2 = new List();
      assertEquals("3. List Object through interface", "0", "" + lst2.size());
   }

   @Test
   public void testCase5() {
      System.out.println("TestCase for Get method in Lists.");

      List lst = new List();
      lst.add(5);
      int[] arr = {1,2,3,4,5,6};
      for (int i = 0; i < arr.length; i++)
         lst.add(arr[i]);
      assertEquals("2. List Object through interface", "5", "" + lst.get(0));
      assertEquals("2. List Object through interface", "3", "" + lst.get(3));
      assertEquals("2. List Object through interface", "6", "" + lst.get(lst.size()-1));
      assertEquals("2. List Object through interface", "-1", "" + lst.get(lst.size()));
      assertEquals("2. List Object through interface", "-1", "" + lst.get(-1));
      assertEquals("2. List Object through interface", "-1", "" + lst.get(45));
      assertEquals("2. List Object through interface", "-1", "" + lst.get(-2));
      
      AbstractList lst1 = new List();
      lst1.add(6);
      for (int i = 0; i < arr.length; i++)
         lst1.add(arr[i]);
      assertEquals("2. List Object through interface", "6", "" + lst1.get(0));
      assertEquals("2. List Object through interface", "4", "" + lst1.get(4));
      assertEquals("2. List Object through interface", "6", "" + lst1.get(lst1.size()-1));
      assertEquals("2. List Object through interface", "-1", "" + lst1.get(lst1.size()));
      assertEquals("2. List Object through interface", "-1", "" + lst1.get(-1));
      assertEquals("2. List Object through interface", "-1", "" + lst1.get(45));
      assertEquals("2. List Object through interface", "-1", "" + lst1.get(-2));
      
      ListInterface lst2 = new List();
      lst2.add(7);
      for (int i = 0; i < arr.length; i++)
         lst2.add(arr[i]);
      assertEquals("3. List Object through interface", "7", "" + lst2.get(0));
      assertEquals("3. List Object through interface", "6", "" + lst2.get(lst2.size()-1));
      assertEquals("3. List Object through interface", "-1", "" + lst2.get(lst2.size()));
      assertEquals("3. List Object through interface", "-1", "" + lst2.get(-1));
      assertEquals("3. List Object through interface", "-1", "" + lst2.get(45));
      assertEquals("3. List Object through interface", "-1", "" + lst2.get(-2));
   }  

   @Test
   public void testCase6() {
      System.out.println("TestCase for Indexof method in Lists.");

      List lst = new List();
      lst.add(5);
      int[] arr = {1,2,3,4,5,6};
      for (int i = 0; i < arr.length; i++)
         lst.add(arr[i]);
      assertEquals("1. List Object", "0", "" + lst.indexOf(5));
      assertEquals("1. List Object", "-1", "" + lst.indexOf(8));
      assertEquals("1. List Object", "-1", "" + lst.indexOf(-1));
      
      AbstractList lst1 = new List();
      lst1.add(6);
      for (int i = 0; i < arr.length; i++)
         lst1.add(arr[i]);
      assertEquals("2. List Object through abstract class", "4", "" + lst1.indexOf(4));
      assertEquals("2. List Object through abstract class", "-1", "" + lst1.indexOf(100));
      assertEquals("2. List Object through abstract class", "-1", "" + lst1.indexOf(-1));
      
      ListInterface lst2 = new List();
      lst2.add(7);
      for (int i = 0; i < arr.length; i++)
         lst2.add(arr[i]);
      assertEquals("3. List Object through interface", "6", "" + lst2.indexOf(6));
      assertEquals("3. List Object through interface", "-1", "" + lst2.indexOf(45));
      assertEquals("3. List Object through interface", "-1", "" + lst2.indexOf(-2));
   }

   @Test
   public void testCase7() {
      System.out.println("TestCase for Contains method in Lists.");

      List lst = new List();
      lst.add(5);
      int[] arr = {1,2,3,4,5,6};
      for (int i = 0; i < arr.length; i++)
         lst.add(arr[i]);
      assertEquals("1. List Object", "true", "" + lst.contains(5));
      assertEquals("1. List Object", "false", "" + lst.contains(8));
      assertEquals("1. List Object", "false", "" + lst.contains(-1));
      
      AbstractList lst1 = new List();
      lst1.add(6);
      for (int i = 0; i < arr.length; i++)
         lst1.add(arr[i]);
      assertEquals("2. List Object through abstract class", "true", "" + lst1.contains(4));
      assertEquals("2. List Object through abstract class", "false", "" + lst1.contains(100));
      assertEquals("2. List Object through abstract class", "false", "" + lst1.contains(-1));
      
      ListInterface lst2 = new List();
      lst2.add(7);
      for (int i = 0; i < arr.length; i++)
         lst2.add(arr[i]);
      assertEquals("3. List Object through interface", "true", "" + lst2.contains(3));
      assertEquals("3. List Object through interface", "false", "" + lst2.contains(45));
      assertEquals("3. List Object through interface", "false", "" + lst2.contains(-2));
   }

   @Test
   public void testCase8() {
      System.out.println("TestCase for Remove method in Lists.");
      
      List lst = new List();
      lst.add(5);
      int[] arr = {1,2,3,4,5,6};
      for (int i = 0; i < arr.length; i++) {
         lst.add(arr[i]);
      }

      lst.remove(5);
      assertEquals("1. List Object", "[5,1,2,3,4,6]", lst.toString());
      
      AbstractList lst1 = new List();
      lst1.add(6);
      for (int i = 0; i < arr.length; i++) {
         lst1.add(arr[i]);
      }
      lst1.remove(3);
      assertEquals("2. List Object through abstract class", "[6,1,2,4,5,6]", lst1.toString());
      
      ListInterface lst2 = new List();
      lst2.add(7);
      for (int i = 0; i < arr.length; i++) {
         lst2.add(arr[i]);
      }
      lst2.remove(5);
      assertEquals("3. List Object through interface", "[7,1,2,3,4,6]" ,lst2.toString());
   }

   @Test
   public void testCase14() {
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
   public void testCase15() {
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

   private void addAll(int[] arr, ListInterface obj) {
      for (int i = 0; i < arr.length; i++) {
         obj.add(arr[i]);
      }
   }
}