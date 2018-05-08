package main.asw.dbupdate;

import main.asw.dbupdate.dao.AgentDao;
import main.asw.dbupdate.dao.AgentDaoImpl;

/**
 * Created by Sergio Faya Fernandez
 */
public class PersistenceFactory {

    private static AgentDao agentDao = new AgentDaoImpl();

    public static AgentDao getAgentDao() {
        return agentDao;
    }

}
