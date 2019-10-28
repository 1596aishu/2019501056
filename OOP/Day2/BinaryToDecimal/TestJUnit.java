/**
 * This is JUnit that tests the binaryToDecimal method that is available 
 * in BinaryToDecimal class. This contains 16 testcases.
 * 
 * Please don't run this file.
 * 
 * You can add your own test cases to this file by just copy and paste the last three 
 * lines of the code (TestCase16).
 * 
 * @author: Siva Sankar
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
	@Test
	public void testCase1() {
		assertEquals(1, BinaryToDecimal.binaryToDecimal("1"));
	}

	@Test
	public void testCase2() {
		assertEquals(0, BinaryToDecimal.binaryToDecimal("0"));
	}

	@Test
	public void testCase3() {
		assertEquals(2, BinaryToDecimal.binaryToDecimal("10"));
	}

	@Test
	public void testCase4() {
		assertEquals(5, BinaryToDecimal.binaryToDecimal("101"));
	}

	@Test
	public void testCase5() {
		assertEquals(10, BinaryToDecimal.binaryToDecimal("00001010"));
	}

	@Test
	public void testCase6() {
		assertEquals(10, BinaryToDecimal.binaryToDecimal("000000001010"));
	}

	@Test
	public void testCase7() {
		assertEquals(3, BinaryToDecimal.binaryToDecimal("0011"));
	}

	@Test
	public void testCase8() {
		assertEquals(341, BinaryToDecimal.binaryToDecimal("101010101"));
	}

	@Test
	public void testCase9() {
		assertEquals(511, BinaryToDecimal.binaryToDecimal("111111111"));
	}

	@Test
	public void testCase10() {
		assertEquals(1, BinaryToDecimal.binaryToDecimal("000000001"));
	}

	@Test
	public void testCase11() {
		assertEquals(127216, BinaryToDecimal.binaryToDecimal("11111000011110000"));
	}

	@Test
	public void testCase12() {
		assertEquals(65536, BinaryToDecimal.binaryToDecimal("10000000000000000"));
	}

	@Test
	public void testCase13() {
		assertEquals(125610, BinaryToDecimal.binaryToDecimal("11110101010101010"));
	}

	@Test
	public void testCase14() {
		assertEquals(21711781, BinaryToDecimal.binaryToDecimal("1010010110100101110100101"));
	}

	@Test
	public void testCase15() {
		assertEquals(983934373, BinaryToDecimal.binaryToDecimal("00111010101001011010010110100101"));
	}

	@Test
	public void testCase16() {
		assertEquals(2057676287, BinaryToDecimal.binaryToDecimal("01111010101001011010010111111111"));
	}
}