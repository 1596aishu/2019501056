/**
 * This is JUnit that tests the miniMaxSum method that is available 
 * in MiniMaxSum class. This contains 8 testcases.
 * 
 * Please don't run this file.
 * 
 * You can add your own test cases to this file by just copy and paste the last three 
 * lines of the code (TestCase8).
 * 
 * @author: Siva Sankar
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
	@Test
	public void testCase1() {
		int[] arr = {1,2,3,4,5};
		assertEquals("14,10", MiniMaxSum.miniMaxSum(arr));
	}

	@Test
	public void testCase2() {
		int[] arr = {1038,3958417,467213,714589,938071};
		assertEquals("6078290,2120911", MiniMaxSum.miniMaxSum(arr));
	}

	@Test
	public void testCase3() {
		int[] arr = {396285104};
		assertEquals("0,0", MiniMaxSum.miniMaxSum(arr));
	}

	@Test
	public void testCase4() {
		int[] arr = {14065,436250,9536,765819,362748590,140638732,436219,95327,73407,362746,38755,43614,95313,73402,36271};
		assertEquals("505858510,143119456", MiniMaxSum.miniMaxSum(arr));
	}

	@Test
	public void testCase5() {
		int[] arr = {42698,02167,1480735,968217,734890,426980,354166,142983,217434,73481};
		assertEquals("4441584,2961992", MiniMaxSum.miniMaxSum(arr));
	}

	@Test
	public void testCase6() {
		int[] arr = {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
		assertEquals("120,120", MiniMaxSum.miniMaxSum(arr));
	}

	@Test
	public void testCase7() {
		int[] arr = {5,5,-25,5,5,-15,5,5,-75,5,5,-5};
		assertEquals("-5,-85", MiniMaxSum.miniMaxSum(arr));
	}

	@Test
	public void testCase8() {
		int[] arr = {1,2};
		assertEquals("2,1", MiniMaxSum.miniMaxSum(arr));
	}
}