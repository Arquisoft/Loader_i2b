package main.asw.agents;

import main.asw.location.LatLng;
import main.asw.util.Checker;
import main.asw.util.WrongParameterException;

/**
 * 
 * @author Sergio Faya Fernandez
 * 
 */
public class Person extends AbstractAgent{

	private LatLng location;
	
	public Person(String name,String email, String id) throws WrongParameterException {
		super(name, email, id);
		this.agentKind = PERSON;
	}
	
	public Person(String name,String email, String id,LatLng location) throws WrongParameterException {
		this(name, email, id);
		Checker.isNull(location);
		this.location = location;
	}

	public LatLng getLocation() {
		return location;
	}
}
