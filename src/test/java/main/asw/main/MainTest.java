package main.asw.main;

import org.junit.Test;

import main.loadAgents.LoadAgents;

public class MainTest {

	@Test
	public void testHelp() {
		System.out.println("Test Help");
		String args[] = { "-h" };
		LoadAgents.main(args);
	}

	@Test
	public void testErrorUsage() {
		System.out.println("Test Error");
		String args[] = { "-error" };
		LoadAgents.main(args);
	}

	@Test
	public void testShortArgs() {
		System.out.println("Test Args Short");
		String args[] = { "-a", "pruebaAgentes.xls", "-t", "pruebaTipos.csv" };
		LoadAgents.main(args);
	}

	@Test
	public void testLongArgs() {
		System.out.println("Test Args Long");
		String args[] = { "--agentsFile", "pruebaAgentes.xls", "--agentsType", "master.csv" };
		LoadAgents.main(args);
	}

	@Test
	public void testPortArgs() {
		System.out.println("Test Port 27017 ");
		String args[] = { "--agentsFile", "pruebaAgentes.xls", "--agentsType", "master.csv", "-p", "27017" };
		LoadAgents.main(args);
	}
	
	@Test
	public void testRemoteMongoArgs() {
		System.out.println("Test Mongo Uri");
		String uri ="mongodb://localhost:27017";
		String args[] = { "--agentsFile", "pruebaAgentes.xls", "--agentsType", "master.csv", "-u", uri };
		LoadAgents.main(args);
	}
}
