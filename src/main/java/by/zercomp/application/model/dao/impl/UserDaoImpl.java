package by.zercomp.application.model.dao.impl;

import by.zercomp.application.model.dao.GenericDao;
import by.zercomp.application.model.dao.UserDao;
import by.zercomp.application.model.dao.builder.CommonBuilder;
import by.zercomp.application.model.entity.User;
import by.zercomp.application.model.exception.DaoException;

import java.util.Optional;

public class UserDaoImpl extends GenericDao<User> implements UserDao {


    protected UserDaoImpl(CommonBuilder<User> builder) {
        super(builder);
    }

    @Override
    public void create(User user, String pwHash) throws DaoException {

    }

    @Override
    public Optional<User> findById(Long id) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByLogin(String login) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) throws DaoException {
        return Optional.empty();
    }

    @Override
    public Optional<String> findPasswordByLogin(String login) throws DaoException {
        return Optional.empty();
    }

    @Override
    public void updatePassword(String email, String newPassword) throws DaoException {

    }
}
