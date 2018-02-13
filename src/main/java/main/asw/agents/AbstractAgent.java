package main.asw.agents;

import main.asw.util.Checker;
import main.asw.util.WrongParameterException;
/**
 * 
 * @author Sergio Faya Fernandez
 *
 */
public abstract class AbstractAgent implements Agent {

	protected String name = null;
	protected String email = null;
	protected  String id = null;
	protected int agentKind = -1;
		
	public AbstractAgent(String name,String email, String id) throws WrongParameterException {
		checkConstructor();
		this.name = name;
		this.email = email;
		this.id = id;
	}
	
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
	
	private void checkConstructor() throws WrongParameterException {
		Checker.isNull(name);
		Checker.isEmpty(name);
		Checker.isNull(email);
		Checker.isEmpty(email);
		Checker.isNull(id);
		Checker.isEmpty(id);
	}

}
