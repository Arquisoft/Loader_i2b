package main.asw.agents;

import org.bson.Document;

import main.asw.location.LatLng;
import main.asw.util.Checker;

/**
 * 
 * @author Sergio Faya Fernandez
 * 
 */
public class Person extends AbstractAgent {

	private LatLng location;

	public Person(String name, String email, String id) {
		super(name, email, id);
		this.agentKind = PERSON;
	}

	public Person(String name, String email, String id, LatLng location) {
		this(name, email, id);
		Checker.isNull(location);
		this.location = location;
	}

	public LatLng getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "{"+extensibleToString() + ", "+location+"}";
	}

	@Override
	public Document getDocument() {
		 Document doc = new Document("name", getName())
                 .append("email", getEmail())
                 .append("agentId", getId())
                 .append("agentKind", getAgentKind())
                 .append("location", getLocation());
		 return doc;
	}

}
