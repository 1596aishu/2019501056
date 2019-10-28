/**
 * This is JUnit that tests the hasTeen method that is available in HasTeen class.
 * This contains 11 testcases.
 * 
 * Please don't run this file.
 * 
 * You can add your own test cases to this file by just copy and paste the last three 
 * lines of the code (TestCase11).
 * 
 * @author: Siva Sankar
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
	@Test
	public void testCase1() {
		assertEquals(true, HasTeen.hasTeen(13, 20, 10));
	}

	@Test
	public void testCase2() {
		assertEquals(true, HasTeen.hasTeen(20, 19, 10));
	}

	@Test
	public void testCase3() {
		assertEquals(true, HasTeen.hasTeen(20, 10, 13));
	}

	@Test
	public void testCase4() {
		assertEquals(false, HasTeen.hasTeen(1, 20, 12));
	}

	@Test
	public void testCase5() {
		assertEquals(true, HasTeen.hasTeen(19, 20, 12));
	}

	@Test
	public void testCase6() {
		assertEquals(true, HasTeen.hasTeen(12, 20, 19));
	}

	@Test
	public void testCase7() {
		assertEquals(false, HasTeen.hasTeen(12, 9, 20));
	}

	@Test
	public void testCase8() {
		assertEquals(true, HasTeen.hasTeen(12, 18, 20));
	}

	@Test
	public void testCase9() {
		assertEquals(true, HasTeen.hasTeen(14, 2, 20));
	}

	@Test
	public void testCase10() {
		assertEquals(false, HasTeen.hasTeen(4, 2, 20));
	}

	@Test
	public void testCase11() {
		assertEquals(false, HasTeen.hasTeen(11, 22, 22));
	}

}
