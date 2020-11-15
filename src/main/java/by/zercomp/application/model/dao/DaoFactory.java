package by.zercomp.application.model.dao;

import by.zercomp.application.model.dao.impl.UserDaoImpl;

public final class DaoFactory {

    private static final DaoFactory instance = new DaoFactory();

    private final UserDao userDao = new UserDaoImpl();

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public UserDao getUserDao() {
        return userDao;
    }
    /*
     public Dao get___Dao() {
        return ___Dao;
     }
     */


}
