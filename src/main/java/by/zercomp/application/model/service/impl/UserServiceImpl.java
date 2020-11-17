package by.zercomp.application.model.service.impl;

import by.zercomp.application.model.dao.DaoFactory;
import by.zercomp.application.model.dao.UserDao;
import by.zercomp.application.model.entity.User;
import by.zercomp.application.model.exception.DaoException;
import by.zercomp.application.model.exception.ServiceException;
import by.zercomp.application.model.service.UserService;

import java.util.Map;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static UserDao userDao = DaoFactory.getInstance().getUserDao();

    @Override
    public Optional<String> signUp(User user, String password) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public Optional<User> signIn(String login, String password) throws ServiceException {
        try {
            Optional<String> hashedPw = userDao.findPasswordByLogin(login);
            if (hashedPw.equals(password)) {
                return userDao.findByLogin(login);
            }
            return Optional.empty();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> findById(long id) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByLogin(String login) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public boolean updatePassword(Map<String, String> changeData) throws ServiceException {
        return false;
    }
}