package main.asw;

import org.junit.Test;

import main.asw.util.Checker;

public class UtilTest {

	
	@Test(expected = IllegalArgumentException.class)
	public void testIsEmpty() {
		Checker.isEmpty("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIsNull() {
		Checker.isNull(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIsNotEmpty() {
		Checker.isEmpty("notempty");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIsNotNull() {
		Checker.isNull(new String());
	}
}
