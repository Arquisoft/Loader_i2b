package main.asw.agents;

import org.bson.Document;

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
		//Check repetition in database
		Checker.isNull(nif);
		Checker.isEmpty(nif);
		return true;
	}

	@Override
	public Document getDocument() {
		 Document doc = new Document("name", getName())
                 .append("email", getEmail())
                 .append("agentId", getId())
                 .append("agentKind", getAgentKind());
		 return doc;
	}
}
