package main.asw.agents;

public class AbstractAgent implements Agent {

	private String name;
	private String email;
	private String id;
	private int agentKind;
		
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public int getAgentKind() {
		return agentKind;
	}

}
