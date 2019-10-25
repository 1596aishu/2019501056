/**
 * This is JUnit that tests the icyHot method that is available 
 * in IcyHot class. This contains 6 testcases.
 * 
 * Please don't run this file.
 * 
 * You can add your own test cases to this file by just copy and paste the last three 
 * lines of the code (TestCase6).
 * 
 * @author: Siva Sankar
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {

	@Test
	public void testCase1() {
		assertEquals(IcyHot.icyHot(120, -1), true);
	}

	@Test
	public void testCase2() {
		assertEquals(IcyHot.icyHot(-1, 120), true);
	}

	@Test
	public void testCase3() {
		assertEquals(IcyHot.icyHot(2, 120), false);
	}

	@Test
	public void testCase4() {
		assertEquals(IcyHot.icyHot(-1, 100), true);
	}

	@Test
	public void testCase5() {
		assertEquals(IcyHot.icyHot(-2, -2), false);
	}

	@Test
	public void testCase6() {
		assertEquals(IcyHot.icyHot(120, 120), false);
	}
}