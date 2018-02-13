package main.asw.agents;

/**
 * 
 * @author Sergio Faya Fernandez
 * 
 */
public class Sensor extends AbstractAgent {
	
	public Sensor(String name,String email, String id) {
		super(name, email, id);
		this.agentKind = SENSOR;
	}
}
