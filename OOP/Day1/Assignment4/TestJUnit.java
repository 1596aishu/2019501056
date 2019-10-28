/**
 * This is JUnit that tests the evenOrOdd methods that is available in 
 * EvenOrOdd class. This contains 10 testcases.
 * 
 * Please don't run this file.
 * 
 * You can add your own test cases to this file by just copy and paste the last three 
 * lines of the code (TestCase10).
 * 
 * @author: Siva Sankar
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
	@Test
	public void testCase1() {
		assertEquals(true, EvenOrOdd.evenOrOdd(2));
	}

	@Test
	public void testCase2() {
		assertEquals(false, EvenOrOdd.evenOrOdd(1));
	}

	@Test
	public void testCase3() {
		assertEquals(false, EvenOrOdd.evenOrOdd(23));
	}

	@Test
	public void testCase4() {
		assertEquals(true, EvenOrOdd.evenOrOdd(232));
	}

	@Test
	public void testCase5() {
		assertEquals(false, EvenOrOdd.evenOrOdd(2223));
	}

	@Test
	public void testCase6() {
		assertEquals(true, EvenOrOdd.evenOrOdd(2234));
	}

	@Test
	public void testCase7() {
		assertEquals(false, EvenOrOdd.evenOrOdd(1211));
	}

	@Test
	public void testCase8() {
		assertEquals(false, EvenOrOdd.evenOrOdd(32767));
	}

	@Test
	public void testCase9() {
		assertEquals(false, EvenOrOdd.evenOrOdd(655353));
	}

	@Test
	public void testCase10() {
		assertEquals(true, EvenOrOdd.evenOrOdd(2147483644));
	}
}