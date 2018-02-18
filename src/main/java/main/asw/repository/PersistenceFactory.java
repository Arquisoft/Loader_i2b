package main.asw.repository;

/**
 * @author Balbuena
 */
public class PersistenceFactory {

    private static AgentDao userDao = new AgentDaoImpl();

    public static AgentDao getUserDAO() {
        return userDao;
    }

}
