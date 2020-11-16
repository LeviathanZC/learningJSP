package by.zercomp.application.model.dao.impl;

import by.zercomp.application.model.dao.ColumnName;
import by.zercomp.application.model.dao.GenericDao;
import by.zercomp.application.model.dao.UserDao;
import by.zercomp.application.model.dao.builder.impl.UserBuilder;
import by.zercomp.application.model.entity.User;
import by.zercomp.application.model.exception.DaoException;

import java.util.Optional;

public class UserDaoImpl extends GenericDao<User> implements UserDao {

    private static final String CREATE_USER = "INSERT INTO users" +
            "(login, email, pw_hash, role_id, name, surname, birthDate) values (?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT users.id, login, email, pw_hash, role, firstName, lastName, " +
            "birthDate FROM users JOIN user_roles ON users.role = user_roles.role_id AND users.id = ?";
    private static final String FIND_BY_LOGIN = "SELECT users.id, login, email, pw_hash, role, firstName, lastName, " +
            "birthDate FROM users WHERE users.login = ?";
    private static final String FIND_BY_EMAIL = "SELECT users.id, login, email, pw_hash, role, firstName, lastName, " +
            "birthDate FROM users WHERE users.email = ?";
    private static final String FIND_PASSWORD_BY_LOGIN = "SELECT pw_hash FROM users WHERE users.login = ?";
    private static final String UPDATE_PASSWORD = "UPDATE users SET pw_hash = ? WHERE email = ?";
    public UserDaoImpl() {
        super(new UserBuilder());
    }

    @Override
    public void create(User user, String pwHash) throws DaoException {
        executeUpdate(CREATE_USER, user.getLogin(), user.getEmail(), pwHash, user.getRole().ordinal(),
                user.getFirstName(), user.getLastName(), user.getBirth());
    }

    @Override
    public Optional<User> findById(Long id) throws DaoException {
        return executeForSingle(FIND_BY_ID, id);
    }

    @Override
    public Optional<User> findByLogin(String login) throws DaoException {
        return executeForSingle(FIND_BY_LOGIN, login);
    }

    @Override
    public Optional<User> findByEmail(String email) throws DaoException {
        return executeForSingle(FIND_BY_EMAIL, email);
    }

    @Override
    public Optional<String> findPasswordByLogin(String login) throws DaoException {
        return findString(FIND_PASSWORD_BY_LOGIN, ColumnName.PASSWORD, login);
    }

    @Override
    public void updatePassword(String email, String newPassword) throws DaoException {
        executeUpdate(UPDATE_PASSWORD, newPassword, email);
    }
}
