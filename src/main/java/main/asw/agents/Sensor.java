package main.asw.agents;

import main.asw.util.Checker;

/**
 * 
 * @author Sergio Faya Fernandez
 * 
 */
public class Sensor extends AbstractAgent {
	
	public Sensor(String name,String email, String id)  {
		super(name, email, id);
		this.agentKind = SENSOR;
	}
	
	@Override
	protected boolean validateId(String nif) {
		Checker.isNull(nif);
		Checker.isEmpty(nif);
		return true;
	}
}
