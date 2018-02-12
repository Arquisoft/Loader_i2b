package main.asw.agents;

public class AgentFactory {

	public Agent createAgent(int agentType) {
		switch (agentType) {
		case 1:
			return new Person();
			break;
		case 2:
			return new Entity();
			break;
		case 3:
			return new Sensor();
		default:
			break;
		}
	}
}
