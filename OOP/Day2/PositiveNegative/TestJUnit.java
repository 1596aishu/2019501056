/**
 * This is JUnit that tests the positiveNegative method that is available 
 * in PositiveNegative class. This contains 19 testcases.
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
		assertEquals(true, PositiveNegative.posNeg(1, -1, false));
	}

	@Test
	public void testCase2() {
		assertEquals(true, PositiveNegative.posNeg(-1, 1, false));
	}

	@Test
	public void testCase3() {
		assertEquals(true, PositiveNegative.posNeg(-4, -5, true));
	}

	@Test
	public void testCase4() {
		assertEquals(false, PositiveNegative.posNeg(-4, -5, false));
	}

	@Test
	public void testCase5() {
		assertEquals(true, PositiveNegative.posNeg(-4, 5, false));
	}

	@Test
	public void testCase6() {
		assertEquals(false, PositiveNegative.posNeg(-4, 5, true));
	}

	@Test
	public void testCase7() {
		assertEquals(false, PositiveNegative.posNeg(1, 1, false));
	}

	@Test
	public void testCase8() {
		assertEquals(false, PositiveNegative.posNeg(-1, -1, false));
	}

	@Test
	public void testCase9() {
		assertEquals(false, PositiveNegative.posNeg(1, -1, true));
	}

	@Test
	public void testCase10() {
		assertEquals(false, PositiveNegative.posNeg(-1, 1, true));
	}

	@Test
	public void testCase11() {
		assertEquals(false, PositiveNegative.posNeg(1, 1, true));
	}

	@Test
	public void testCase12() {
		assertEquals(true, PositiveNegative.posNeg(-1, -1, true));
	}

	@Test
	public void testCase13() {
		assertEquals(true, PositiveNegative.posNeg(5, -5, false));
	}

	@Test
	public void testCase14() {
		assertEquals(true, PositiveNegative.posNeg(-6, 6, false));
	}

	@Test
	public void testCase15() {
		assertEquals(false, PositiveNegative.posNeg(-5, -6, false));
	}

	@Test
	public void testCase16() {
		assertEquals(false, PositiveNegative.posNeg(-2, -1, false));
	}

	@Test
	public void testCase17() {
		assertEquals(false, PositiveNegative.posNeg(1, 2, false));
	}

	@Test
	public void testCase18() {
		assertEquals(false, PositiveNegative.posNeg(-5, 6, true));
	}

	@Test
	public void testCase19() {
		assertEquals(true, PositiveNegative.posNeg(-5, -5, true));
	}
}