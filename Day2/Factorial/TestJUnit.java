/**
 * This is JUnit that tests the factorial method that is available 
 * in Factorial class. This contains 13 testcases.
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
		assertEquals(1, Factorial.factorial(1));
	}

	@Test
	public void testCase2() {
		assertEquals(120, Factorial.factorial(5));
	}

	@Test
	public void testCase3() {
		assertEquals(2, Factorial.factorial(2));
	}

	@Test
	public void testCase4() {
		assertEquals(1, Factorial.factorial(0));
	}

	@Test
	public void testCase5() {
		assertEquals(3628800, Factorial.factorial(10));
	}

	@Test
	public void testCase6() {
		assertEquals(39916800, Factorial.factorial(11));
	}

	@Test
	public void testCase7() {
		assertEquals(479001600, Factorial.factorial(12));
	}

	@Test
	public void testCase8() {
		assertEquals(1307674368000L, Factorial.factorial(15));
	}

	@Test
	public void testCase9() {
		assertEquals(121645100408832000L, Factorial.factorial(19));
	}

	@Test
	public void testCase10() {
		assertEquals(2432902008176640000L, Factorial.factorial(20));
	}

	@Test
	public void testCase11() {
		assertEquals(-1, Factorial.factorial(21));
	}

	@Test
	public void testCase12() {
		assertEquals(-1, Factorial.factorial(22));
	}

	@Test
	public void testCase13() {
		assertEquals(-1, Factorial.factorial(-1));
	}
}