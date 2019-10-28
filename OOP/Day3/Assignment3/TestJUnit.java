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
		int[] res = {1,4,9};
		Assert.assertArrayEquals(res, Squares.squared(arr));
	}

	@Test
	public void testCase2() {
		int[] arr = {6, 8, -6, -8, 1};
		int[] res = {36, 64, 36, 64, 1};
		Assert.assertArrayEquals(res, Squares.squared(arr));
	}

	@Test
	public void testCase3() {
		int[] arr = {};
		int[] res = {};
		Assert.assertArrayEquals(res, Squares.squared(arr));
	}

	@Test
	public void testCase4() {
		int[] arr = {12};
		int[] res = {144};
		Assert.assertArrayEquals(res, Squares.squared(arr));
	}

	@Test
	public void testCase5() {
		int[] arr = {5, 10};
		int[] res = {25, 100};
		Assert.assertArrayEquals(res, Squares.squared(arr));
	}

	@Test
	public void testCase6() {
		int[] arr = {6, -3, 12, 23, 4, 1, 19, 11, 2, 3, 2};
		int[] res = {36, 9, 144, 529, 16, 1, 361, 121, 4, 9, 4};
		Assert.assertArrayEquals(res, Squares.squared(arr));
	}

}