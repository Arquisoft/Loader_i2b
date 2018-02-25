package main.asw.repository.daoTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.asw.agents.Agent;
import main.asw.repository.dao.AgentDao;
import main.asw.repository.dao.AgentDaoImpl;

public class DaoTest {
	
	private Agent ag1;
	private Agent ag2;
	private AgentDao dao;

	@Before
	public void setUp() {
		ag1 = new Agent(1, "Agent", "agent@gmail.com", "05936542N");
		ag2 = new Agent(1, "Agent2", "agent2@gmail.com", "05936542N");
	}
	
	@Test
	public void testConstructor(){
		dao = new AgentDaoImpl();
	}
	
	@Test
	public void testSaveAgentOk(){
		dao = new AgentDaoImpl();
		boolean result = dao.saveAgent(ag1);
		Assert.assertTrue(result);
	}
	
	@Test 
	public void testSaveAgentNotOk(){
		dao = new AgentDaoImpl();
		dao.saveAgent(ag1);
		boolean result = dao.saveAgent(ag2);
		Assert.assertTrue(result);
	}
}
