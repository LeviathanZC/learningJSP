package by.zercomp.application.model.service;

import by.zercomp.application.model.entity.User;
import by.zercomp.application.model.exception.ServiceException;

import java.util.Map;
import java.util.Optional;

public interface UserService {

    Optional<String> signUp(User user, String password) throws ServiceException;

    Optional<User> signIn(String login, String password) throws ServiceException;

    Optional<User> findById(long id) throws ServiceException;

    Optional<User> findByLogin(String login) throws ServiceException;

    Optional<User> findByEmail(String email) throws ServiceException;

    boolean updatePassword(Map<String, String> changeData) throws ServiceException;
}
