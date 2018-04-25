package main.asw.repository.dao;

import com.mongodb.MongoClientURI;

import main.asw.agents.Agent;

/**
 * 
 * @author Sergio Faya Fernandez
 *
 */
public interface AgentDao {

	/**
	 * Saves a given agent in the database
	 *
	 * @param agent Agent to be saved
	 * @return true if the agent could be saved false otherwise (if the agent already
	 *         exists in the DB)
	 */
	boolean saveAgent(Agent agent);

	/**
	 * Specifies the port in a localhost connection
	 * @param port
	 */
	void setMongoHost(int port);
	
	/**
	 * Specifies the uri of the database
	 * @param mongoUri
	 */
	void setRemoteMongoConnection(MongoClientURI mongoUri);
}
