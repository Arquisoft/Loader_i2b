package main.asw;

import java.text.ParseException;

import org.junit.Test;

import cucumber.api.java.Before;
import main.asw.agents.Agent;
import main.asw.agents.AgentFactory;
import main.asw.location.LatLng;

public class AgentsTest {

	private LatLng nava;
	private LatLng oviedo;

	@Before
	public void setUp() {
		nava = new LatLng(43.358764, -5.508228);
		oviedo = new LatLng(43.361914, -5.849389);
	}

	// Factory
	@Test(expected = IllegalArgumentException.class)
	public void testCreateInexistingTypeAgent() {
		AgentFactory.createAgent(0, "person", "person@gmail.com", "05936542N", nava);
	}

	// people
	@Test
	public void testCreatePersonRight() {
		AgentFactory.createAgent(Agent.PERSON, "person", "person@gmail.com", "05936542N");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreatePersonWrongName() {
		AgentFactory.createAgent(Agent.PERSON, null, "person@gmail.com", "05936542N");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreatePersonEmptyName() {
		AgentFactory.createAgent(Agent.PERSON, "", "person@gmail.com", "05936542N");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreatePersonEmptyMail() {
		AgentFactory.createAgent(Agent.PERSON, "person", "", "05936542N");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreatePersonWrongEmail() {
		AgentFactory.createAgent(Agent.PERSON, "person", null, "05936542N");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreatePersonWrongFormatEmail() {
		AgentFactory.createAgent(Agent.PERSON, "person", "persongmail.com", "05936542N");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreatePersonWrongId() {
		AgentFactory.createAgent(Agent.PERSON, "person", "person@gmail.com", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreatePersonWrongIdLetter() {
		AgentFactory.createAgent(Agent.PERSON, "person", "person@gmail.com", "098206468");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreatePersonWrongIdLenght() {
		AgentFactory.createAgent(Agent.PERSON, "person", "person@gmail.com", "0982064681454a");
	}

	@Test
	public void testCreatePersonRightLocation() {
		AgentFactory.createAgent(Agent.PERSON, "person", "person@gmail.com", "05936542N", oviedo);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreatePersonWrongLocation() {
		AgentFactory.createAgent(Agent.PERSON, "person", "persongmail.com", "05936542N", null);
	}

	// entities
	@Test
	public void testCreateEntityRight() {
		AgentFactory.createAgent(Agent.ENTITY, "entity", "entity@gmail.com", "05936542N");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateEntityWrongName() {
		AgentFactory.createAgent(Agent.ENTITY, null, "entity@gmail.com", "05936542N");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateEntityEmptyName() {
		AgentFactory.createAgent(Agent.ENTITY, "", "entity@gmail.com", "05936542N");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateEntityEmptyEmail() {
		AgentFactory.createAgent(Agent.ENTITY, "entity", "", "05936542N");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateEntityWrongEmail() {
		AgentFactory.createAgent(Agent.ENTITY, "entity", null, "05936542N");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateEntityWrongId() {
		AgentFactory.createAgent(Agent.PERSON, "person", "person@gmail.com", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateEntityWrongFormatEmail() {
		AgentFactory.createAgent(Agent.ENTITY, "entity", "entitygmail.com", "05936542N");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateEntityWrongIdLetter() {
		AgentFactory.createAgent(Agent.ENTITY, "entity", "entitygmail.com", "05936542P");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateEntityWrongIdLenght() {
		AgentFactory.createAgent(Agent.ENTITY, "entity", "entitygmail.com", "05936545452N");
	}

	@Test
	public void testCreateEntityRightLocation() {
		AgentFactory.createAgent(Agent.ENTITY, "entity", "entity@gmail.com", "05936542N", oviedo);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateEntityWrongLocation() {
		AgentFactory.createAgent(Agent.ENTITY, "entity", "entitygmail.com", "05936545452N", null);
	}

	// sensors
	@Test
	public void testCreateSensorRight() {
		AgentFactory.createAgent(Agent.SENSOR,"sensor","sensor@gmail.com","11402364E");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateSensorWrongName() {
		AgentFactory.createAgent(Agent.SENSOR,null,"sensor@gmail.com","11402364E");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateSensorEmptyName() {
		AgentFactory.createAgent(Agent.SENSOR,"","sensor@gmail.com","11402364E");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateSensorWrongFormatEmail() {
		AgentFactory.createAgent(Agent.SENSOR,"sensor","sensorgmail.com","11402364E");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCreateSensorWrongEmail() {
		AgentFactory.createAgent(Agent.SENSOR,"sensor",null,"11402364E");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateSensorEmptyEmail() {
		AgentFactory.createAgent(Agent.SENSOR,"sensor","","11402364E");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateSensorWrongId() {
		AgentFactory.createAgent(Agent.SENSOR,"sensor","sensor@gmail.com",null);
	}	

	@Test(expected = IllegalArgumentException.class)
	public void testCreateSensorWrongIdLenght() {
		AgentFactory.createAgent(Agent.SENSOR,"sensor","sensor@gmail.com","");
	}
}
