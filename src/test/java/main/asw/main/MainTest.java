package main.asw.main;

import static org.junit.Assert.fail;

import org.junit.Test;

import main.loadAgents.LoadAgents;

public class MainTest {
	
	@Test
	public void testCorrect() {
		fail();
	}
	
	@Test
	public void testError() {
		LoadAgents.main("");
		fail();
	}
}
