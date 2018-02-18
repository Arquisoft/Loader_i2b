package main.asw.repository;

/**
 * @author Balbuena
 */
public class PersistenceFactory {

    private static UserDao userDao = new UserDaoImpl();

    public static UserDao getUserDAO() {
        return userDao;
    }

}
