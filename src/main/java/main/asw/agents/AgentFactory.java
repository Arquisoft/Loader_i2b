package main.asw.agents;
/**
 * 
 * @author Sergio Faya Fernandez
 *
 */
public class AgentFactory {

	public static Agent createAgent(int agentType,String name,String email, String id) {
		switch (agentType) {
		case 1:
			return new Person(null, null, null);
		case 2:
			return new Entity(null, null, null);
		case 3:
			return new Sensor(null, null, null);
		default:
			throw new RuntimeException("This type of user doesn't exist");
		}
	}
}
