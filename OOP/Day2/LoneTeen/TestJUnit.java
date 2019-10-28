/**
 * This is JUnit that tests the loneTeen method that is available in LoneTeen
 * class. This contains 13 testcases.
 * 
 * Please don't run this file.
 * 
 * You can add your own test cases to this file by just copy and paste the last three 
 * lines of the code (TestCase13).
 * 
 * @author: Siva Sankar
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
	@Test
	public void testCase1() {
		assertEquals(true, LoneTeen.loneTeen(13, 99));
	}

	@Test
	public void testCase2() {
		assertEquals(true, LoneTeen.loneTeen(21, 19));
	}

	@Test
	public void testCase3() {
		assertEquals(false, LoneTeen.loneTeen(13, 13));
	}

	@Test
	public void testCase4() {
		assertEquals(true, LoneTeen.loneTeen(14, 20));
	}

	@Test
	public void testCase5() {
		assertEquals(true, LoneTeen.loneTeen(20, 15));
	}

	@Test
	public void testCase6() {
		assertEquals(false, LoneTeen.loneTeen(16, 17));
	}

	@Test
	public void testCase7() {
		assertEquals(true, LoneTeen.loneTeen(16, 9));
	}

	@Test
	public void testCase8() {
		assertEquals(false, LoneTeen.loneTeen(16, 18));
	}

	@Test
	public void testCase9() {
		assertEquals(false, LoneTeen.loneTeen(13, 19));
	}

	@Test
	public void testCase10() {
		assertEquals(true, LoneTeen.loneTeen(13, 20));
	}

	@Test
	public void testCase11() {
		assertEquals(true, LoneTeen.loneTeen(6, 18));
	}

	@Test
	public void testCase12() {
		assertEquals(true, LoneTeen.loneTeen(99, 13));
	}

	@Test
	public void testCase13() {
		assertEquals(false, LoneTeen.loneTeen(99, 99));
	}
}