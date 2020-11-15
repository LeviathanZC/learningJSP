package by.zercomp.application.model.dao;

import by.zercomp.application.model.entity.User;
import by.zercomp.application.model.exception.DaoException;

import java.util.Optional;

public interface UserDao {

    void create(User user, String pwHash) throws DaoException;

    Optional<User> findById(Long id) throws DaoException;

    Optional<User> findByLogin(String login) throws DaoException;

    Optional<User> findByEmail(String email) throws DaoException;

    Optional<String> findPasswordByLogin(String login) throws DaoException;

    void updatePassword(String email, String newPassword) throws DaoException;
}
