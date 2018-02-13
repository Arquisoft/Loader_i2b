package main.asw.agents;

import main.asw.util.WrongParameterException;

/**
 * 
 * @author Sergio Faya Fernandez
 * 
 */
public class Sensor extends AbstractAgent {
	
	public Sensor(String name,String email, String id) throws WrongParameterException {
		super(name, email, id);
		this.agentKind = SENSOR;
	}
}
