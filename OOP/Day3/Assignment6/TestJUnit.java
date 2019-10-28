/**
 * This is JUnit that tests the lower method in StringHandling class.
 * This contains 6 testcases.
 * 
 * Please don't run this file.
 * You can add your own test cases to this file by just copy and 
 * paste the last three lines of the code (TestCase6).
 * 
 * @author Siva Sankar
 */

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
	@Test
	public void testCase1() {
		int[] arr = {1,2,3};
		assertEquals(2.0, Stats.mean(arr), 0.01);
	}

	@Test
	public void testCase2() {
		int[] arr = {6, 8, -6, -8, 1};
		assertEquals(0.2, Stats.mean(arr), 0.01);
	}

	@Test
	public void testCase3() {
		int[] arr = {};
		assertEquals(0, Stats.mean(arr), 0.0);
	}

	@Test
	public void testCase4() {
		int[] arr = {12};
		assertEquals(12.0, Stats.mean(arr), 0.01);
	}

	@Test
	public void testCase5() {
		int[] arr = {5, 10};
		assertEquals(7.5, Stats.median(arr), 0.01);
	}

	@Test
	public void testCase6() {
		int[] arr = {6, -3, 12, 23, 4, 1, 19, 11, 2, 3, 2};
		assertEquals(4.0, Stats.median(arr), 0.01);
	}

	@Test
	public void testCase7() {
		int[] arr = {6, -3, 12, 23, 4, 1, 19, 11, 2, 3, 2, 3};
		assertEquals(3.5, Stats.median(arr), 0.01);
	}

	@Test
	public void testCase8() {
		int[] arr = {1,2,3};
		assertEquals(2.0, Stats.median(arr),0.01);
	}

	@Test
	public void testCase9() {
		int[] arr = {1,2,3,4};
		assertEquals(2.5, Stats.median(arr), 0.01);
	}

	@Test
	public void testCase10() {
		int[] arr = {1,2,3,4};
		assertEquals(0.0, Stats.mode(arr), 0.01);
	}

	@Test
	public void testCase11() {
		int[] arr = {1,2,3,4,1};
		assertEquals(1, Stats.mode(arr));
	}

	@Test
	public void testCase12() {
		int[] arr = {1,2,3,4,4};
		assertEquals(4, Stats.mode(arr));
	}

	@Test
	public void testCase13() {
		int[] arr = {1,2,3,4,4,4,2,2,2,3,3,3};
		assertEquals(2, Stats.mode(arr));
	}

	@Test
	public void testCase14() {
		int[] arr = {1,2,3,4,5};
		assertEquals(0.0, Stats.mode(arr), 0.01);
	}

	@Test
	public void testCase15() {
		int[] arr = {1,2,3,4,5};
		assertEquals(2.0, Stats.variance(arr), 0.01);
	}

	@Test
	public void testCase16() {
		int[] arr = {1,2,3,4,5};
		assertEquals(1.4142135623730951, Stats.standardDeviation(arr), 0.01);
	}

	@Test
	public void testCase17() {
		int[] arr = {7,7,8,8,3};
		assertEquals(3.44, Stats.variance(arr), 0.01);
	}

	@Test
	public void testCase18() {
		int[] arr = {7,7,8,8,3};
		assertEquals(1.8547236990991407, Stats.standardDeviation(arr), 0.01);
	}
}