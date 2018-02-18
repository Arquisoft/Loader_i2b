package main.asw.repository;

import main.asw.agents.Agent;

/**
 * @author Balbuena
 */
public interface AgentDao {

    /**
     * Saves a given user in the database
     *
     * @param u User to be saved
     * @return  true if the user could be saved
     *          false otherwise (if the user already exists in the DB)
     */
    boolean saveUser(Agent u);

    void setMongoHost(String arg);
}
