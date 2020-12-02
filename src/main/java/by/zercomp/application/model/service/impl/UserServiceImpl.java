package by.zercomp.application.model.service.impl;

import by.zercomp.application.model.dao.DaoFactory;
import by.zercomp.application.model.dao.UserDao;
import by.zercomp.application.model.entity.User;
import by.zercomp.application.model.exception.DaoException;
import by.zercomp.application.model.exception.ServiceException;
import by.zercomp.application.model.service.DTMapKey;
import by.zercomp.application.model.service.ErrorMsg;
import by.zercomp.application.model.service.UserService;
import by.zercomp.application.model.validator.UserValidator;
import by.zercomp.application.util.ProjectSecurity;

import java.util.Map;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static UserDao userDao = DaoFactory.getInstance().getUserDao();
    private static UserValidator validator = UserValidator.getInstance();

    @Override
    public Optional<String> signUp(User user, String password) throws ServiceException {
        Optional<String> error = Optional.empty();
        try {
            if (userDao.findByLogin(user.getLogin()).isPresent()) {
                error = Optional.of(ErrorMsg.LOGIN_OCCUPIED.toString());
            } else {
                password = ProjectSecurity.generateHash(password);
                userDao.create(user, password);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> signIn(String login, String password) throws ServiceException {
        try {
            Optional<String> hashedPw = userDao.findPasswordByLogin(login);
            if (hashedPw.isPresent() && hashedPw.get().equals(ProjectSecurity.generateHash(password))) {
                return userDao.findByLogin(login);
            }
            return Optional.empty();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> findById(long id) throws ServiceException {
        try {
            return userDao.findById(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> findByLogin(String login) throws ServiceException {
        try {
            return userDao.findByLogin(login);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<User> findByEmail(String email) throws ServiceException {
        try {
            return userDao.findByEmail(email);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean updatePassword(Map<String, String> changeData) throws ServiceException {
        String login = changeData.get(DTMapKey.LOGIN);
        String oldPw = changeData.get(DTMapKey.OLD_PW);
        Optional<User> user = signIn(login, oldPw);
        if (user.isPresent() && validator.checkPasswords(changeData)) {
            updatePassword(user.get().getEmail(), changeData.get(DTMapKey.PASSWORD));
            return true;
        }
        if (!user.isPresent()) {
            //TODO
        }
        return false;
    }

    private void updatePassword(String email, String newPassword) throws ServiceException {
        try {
            String hashedPw = ProjectSecurity.generateHash(newPassword);
            userDao.updatePassword(email, hashedPw);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
