package by.zercomp.application.model.dao.impl;

import by.zercomp.application.model.dao.GenericDao;
import by.zercomp.application.model.dao.UserDao;
import by.zercomp.application.model.dao.builder.impl.UserBuilder;
import by.zercomp.application.model.entity.User;
import by.zercomp.application.model.exception.DaoException;

import java.util.Optional;

public class UserDaoImpl extends GenericDao<User> implements UserDao {

    private static final String CREATE_USER = "INSERT INTO users" +
            "(login, email, pw_hash, role_code, name, surname, birthDate) values (?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT login, email, pw_hash, role_code, name, surname, birthDate " +
            "FROM users JOIN user_roles ON users.role_code = user_roles.role_id AND users.id = ?";

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
