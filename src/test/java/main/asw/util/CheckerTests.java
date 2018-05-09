package main.asw.util;

import static org.junit.Assert.fail;

import org.junit.Test;

public class CheckerTests {
	
	@Test(expected = IllegalArgumentException.class)
	public void testIsEmpty() {
		Checker.isEmpty("notempty");
		Checker.isEmpty("");
		//If the exception is not thrown fail
		fail();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIsNull() {
		Checker.isNull("");
		Checker.isNull(null);
		//If the exception is not thrown fail
		fail();
	}
	
	@Test(expected = IllegalArgumentException.class)	
	public void testIsGreaterThanOrEqualToZero() {
		Checker.isLessThanZero(5);
		Checker.isLessThanZero(0);
		
		Checker.isLessThanZero(-1);
		fail();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIsLowerThanZero() {
		Checker.isLessThanZero(-1);
		//If the exception is not thrown fail
		fail();
	}
}