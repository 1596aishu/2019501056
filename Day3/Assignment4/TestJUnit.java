/**
 * This is JUnit that tests the lower method in StringHandling class.
 * This contains 6 testcases.
 * 
 * Please don't run this file.
 * 
 * You can add your own test cases to this file by just copy and 
 * paste the last three lines of the code	 (TestCase6).
 * 
 * @author Siva Sankar
 */

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
	@Test
	public void testCase1() {
		String[] arr = {"Hello", "Hi"};
		String[] res = {"hello", "hi"};
		Assert.assertArrayEquals(StringHandling.lower(arr), res);
	}

	@Test
	public void testCase2() {
		String[] arr = {"AAA", "BBB", "ccc"};
		String[] res = {"aaa", "bbb", "ccc"};
		Assert.assertArrayEquals(StringHandling.lower(arr), res);
	}

	@Test
	public void testCase3() {
		String[] arr = {"KitteN", "ChocolaTE"};
		String[] res = {"kitten", "chocolate"};
		Assert.assertArrayEquals(StringHandling.lower(arr), res);
	}

	@Test
	public void testCase4() {
		String[] arr = {};
		String[] res = {};
		Assert.assertArrayEquals(StringHandling.lower(arr), res);
	}

	@Test
	public void testCase5() {
		String[] arr = {"EMPTY", ""};
		String[] res = {"empty", ""};
		Assert.assertArrayEquals(StringHandling.lower(arr), res);
	}

	@Test
	public void testCase6() {
		String[] arr = {"aaX", "bYb", "Ycc", "ZZZ"};
		String[] res = {"aax", "byb", "ycc", "zzz"};
		Assert.assertArrayEquals(StringHandling.lower(arr), res);
	}

}