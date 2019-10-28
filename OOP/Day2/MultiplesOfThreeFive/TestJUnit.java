/**
 * This is JUnit that tests the or35 method that is available 
 * in MultiplesOfThreeFive class. This contains 22 testcases.
 * 
 * Please don't run this file.
 * 
 * You can add your own test cases to this file by just copy and paste the last three 
 * lines of the code (TestCase4).
 * 
 * @author: Siva Sankar
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
	@Test
	public void testCase1() {
		assertEquals(true, MultiplesOfThreeFive.or35(3));
	}

	@Test
	public void testCase2() {
		assertEquals(true, MultiplesOfThreeFive.or35(10));
	}

	@Test
	public void testCase3() {
		assertEquals(false, MultiplesOfThreeFive.or35(8));
	}

	@Test
	public void testCase4() {
		assertEquals(true, MultiplesOfThreeFive.or35(15));
	}

	@Test
	public void testCase5() {
		assertEquals(true, MultiplesOfThreeFive.or35(5));
	}

	@Test
	public void testCase6() {
		assertEquals(true, MultiplesOfThreeFive.or35(9));
	}

	@Test
	public void testCase7() {
		assertEquals(false, MultiplesOfThreeFive.or35(4));
	}

	@Test
	public void testCase8() {
		assertEquals(false, MultiplesOfThreeFive.or35(7));
	}

	@Test
	public void testCase9() {
		assertEquals(true, MultiplesOfThreeFive.or35(6));
	}

	@Test
	public void testCase10() {
		assertEquals(false, MultiplesOfThreeFive.or35(17));
	}

	@Test
	public void testCase11() {
		assertEquals(true, MultiplesOfThreeFive.or35(18));
	}

	@Test
	public void testCase12() {
		assertEquals(false, MultiplesOfThreeFive.or35(29));
	}

	@Test
	public void testCase13() {
		assertEquals(true, MultiplesOfThreeFive.or35(20));
	}

	@Test
	public void testCase14() {
		assertEquals(true, MultiplesOfThreeFive.or35(21));
	}

	@Test
	public void testCase15() {
		assertEquals(false, MultiplesOfThreeFive.or35(22));
	}

	@Test
	public void testCase16() {
		assertEquals(true, MultiplesOfThreeFive.or35(45));
	}

	@Test
	public void testCase17() {
		assertEquals(true, MultiplesOfThreeFive.or35(99));
	}

	@Test
	public void testCase18() {
		assertEquals(true, MultiplesOfThreeFive.or35(100));
	}

	@Test
	public void testCase19() {
		assertEquals(false, MultiplesOfThreeFive.or35(101));
	}

	@Test
	public void testCase20() {
		assertEquals(false, MultiplesOfThreeFive.or35(121));
	}

	@Test
	public void testCase21() {
		assertEquals(false, MultiplesOfThreeFive.or35(122));
	}

	@Test
	public void testCase22() {
		assertEquals(true, MultiplesOfThreeFive.or35(123));
	}
}