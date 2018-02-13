package main.asw.agents;

import main.asw.location.LatLng;

/**
 * 
 * @author Sergio Faya Fernandez
 *
 */
public class AgentFactory {

	public static Agent createAgent(int agentType, String name, String email, String id, LatLng location) {
		switch (agentType) {
		case 1:
			if (location != null) {
				return new Person(name, email, id, location);
			}
			return new Person(name, email, id);
		case 2:
			if (location != null) {
				return new Entity(name, email, id, location);
			}
			return new Entity(name, email, id);
		case 3:
			return new Sensor(name, email, id);
		default:
			throw new RuntimeException("This type of user doesn't exist");
		}
	}
}
