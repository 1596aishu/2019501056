/**
 * This is JUnit that tests the methods of the Clock.
 * This contains 2 testcases.
 * 
 * Please don't run this file.
 * You can add your own test cases to this file by just copy and 
 * paste the last three lines of the code (TestCase2).
 * 
 * @author: Siva Sankar
 * @author: Nemnous
 *
 */

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class TestJUnit {

   @Test
   public void testCase1() {
      CSVReader obj = new CSVReader();
      obj.readCSV("mtcars.csv");

      assertEquals("1. ", 32, obj.rowCount());
      assertEquals("2. ", 12, obj.fieldCount());
      assertEquals("3. ", "cyl", obj.getFieldName(3));
      assertEquals("4. ", "[Mazda RX4, 21, 6, 160, 110, 3.9, 2.62, 16.46, 0, 1, 4, 4]", Arrays.toString(obj.getRow(1)));
      assertEquals("5. ",
            "[Mazda RX4,21,6,160,110,3.9,2.62,16.46,0,1,4,4, Mazda RX4 Wag,21,6,160,110,3.9,2.875,17.02,0,1,4,4, Datsun 710,22.8,4,108,93,3.85,2.32,18.61,1,1,4,1, Hornet 4 Drive,21.4,6,258,110,3.08,3.215,19.44,1,0,3,1]",
            Arrays.toString(obj.getRows(1, 5)));
      assertEquals("6. ",
            "[160, 160, 108, 258, 360, 225, 360, 146.7, 140.8, 167.6, 167.6, 275.8, 275.8, 275.8, 472, 460, 440, 78.7, 75.7, 71.1, 120.1, 318, 304, 350, 400, 79, 120.3, 95.1, 351, 145, 301, 121]",
            Arrays.toString(obj.getColumnValues(3)));
      assertEquals("7. ", "vs", obj.getFieldName(9));
      assertEquals("8. ", "[Merc 230, 22.8, 4, 140.8, 95, 3.92, 3.15, 22.9, 1, 0, 4, 2]",
            Arrays.toString(obj.getRow(9)));
      assertEquals("9. ",
            "[Datsun 710,22.8,4,108,93,3.85,2.32,18.61,1,1,4,1, Hornet 4 Drive,21.4,6,258,110,3.08,3.215,19.44,1,0,3,1, Hornet Sportabout,18.7,8,360,175,3.15,3.44,17.02,0,0,3,2, Valiant,18.1,6,225,105,2.76,3.46,20.22,1,0,3,1, Duster 360,14.3,8,360,245,3.21,3.57,15.84,0,0,3,4, Merc 240D,24.4,4,146.7,62,3.69,3.19,20,1,0,4,2]",
            Arrays.toString(obj.getRows(3, 9)));
      assertEquals("10. ",
            "[1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1]",
            Arrays.toString(obj.getColumnValues(9)));
      assertEquals("13. ", null, obj.getFieldName(-5));
   }

   @Test
   public void testCase2() {
      CSVReader obj = new CSVReader();
      obj.readCSV("SalesRecord.csv");
      assertEquals("1. ", 100, obj.rowCount());
      assertEquals("2. ", 14, obj.fieldCount());
      assertEquals("3. ", "Unit Price", obj.getFieldName(10));
      assertEquals("4. ",
            "[Asia, Mongolia, Personal Care, Offline, C, 2/19/2014, 832401311, 2/23/2014, , 81.73, 56.67, 400558.73, 277739.67, 122819.06]",
            Arrays.toString(obj.getRow(15)));
      assertEquals("5. ",
            "[Central America and the Caribbean,Grenada,Cereal,Online,C,8/22/2012,963881480,9/15/2012,2804,205.7,117.11,576782.8,328376.44,248406.36]",
            Arrays.toString(obj.getRows(2, 3)));
      assertNull("6. ",  obj.getRows(-2, 3));
      assertEquals("7. ",
            "[255.28, 205.7, 651.21, 9.33, 651.21, 255.28, 668.27, 154.06, 81.73, 205.7, 154.06, 109.28, 109.28, 668.27, 81.73, 109.28, 437.2, 47.45, 668.27, 421.89, 255.28, 255.28, 152.58, 9.33, 81.73, 437.2, 9.33, 9.33, 47.45, 668.27, 437.2, 81.73, 651.21, 668.27, 152.58, 81.73, 9.33, 421.89, 651.21, 651.21, 81.73, 437.2, 205.7, 154.06, 109.28, 205.7, 437.2, 81.73, 109.28, 651.21, 109.28, 9.33, , 651.21, 9.33, 109.28, 109.28, 437.2, , 437.2, 205.7, 255.28, 651.21, 109.28, 437.2, 437.2, 81.73, 109.28, 651.21, 109.28, 651.21, 9.33, 47.45, 205.7, 437.2, 668.27, 47.45, 154.06, 255.28, 437.2, 668.27, 109.28, 437.2, 152.58, 154.06, 81.73, 47.45, 255.28, 9.33, 47.45, 651.21, 47.45, 651.21, 437.2, 47.45, 109.28, 9.33, 154.06, 81.73, 668.27]",
            Arrays.toString(obj.getColumnValues(9)));
      assertEquals("8. ", null, obj.getFieldName(-12));
      assertNull("9. ",  obj.getRow(-25));
      assertNull("10. ",  obj.getRows(15, 3));
      assertNull("11. ",  obj.getRows(-2, 0));
      assertEquals("12. ",
            "[255.28, 205.7, 651.21, 9.33, 651.21, 255.28, 668.27, 154.06, 81.73, 205.7, 154.06, 109.28, 109.28, 668.27, 81.73, 109.28, 437.2, 47.45, 668.27, 421.89, 255.28, 255.28, 152.58, 9.33, 81.73, 437.2, 9.33, 9.33, 47.45, 668.27, 437.2, 81.73, 651.21, 668.27, 152.58, 81.73, 9.33, 421.89, 651.21, 651.21, 81.73, 437.2, 205.7, 154.06, 109.28, 205.7, 437.2, 81.73, 109.28, 651.21, 109.28, 9.33, , 651.21, 9.33, 109.28, 109.28, 437.2, , 437.2, 205.7, 255.28, 651.21, 109.28, 437.2, 437.2, 81.73, 109.28, 651.21, 109.28, 651.21, 9.33, 47.45, 205.7, 437.2, 668.27, 47.45, 154.06, 255.28, 437.2, 668.27, 109.28, 437.2, 152.58, 154.06, 81.73, 47.45, 255.28, 9.33, 47.45, 651.21, 47.45, 651.21, 437.2, 47.45, 109.28, 9.33, 154.06, 81.73, 668.27]",
            Arrays.toString(obj.getColumnValues(9)));
      assertNull("13. ",  obj.getRow(1000));
      assertNull("14. ",  obj.getRows(15, 1500));
   }

   @Test
   public void testCase3() {
      CSVReader obj = new CSVReader();
      obj.readCSV("Imempty.csv");
      // System.out.println(obj.dataFrame);
      assertEquals("1. ", -1, obj.rowCount());
      assertEquals("2. ", -1, obj.fieldCount());
      assertNull("3. ", obj.getRow(1));
      assertNull("4. ", obj.getRows(2, 6));
      assertNull("5. ", obj.getFieldName(10));
      assertNull("6. ", obj.getColumnValues(5));
   }
}