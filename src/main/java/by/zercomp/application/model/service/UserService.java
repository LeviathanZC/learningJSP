package by.zercomp.application.model.service;

import java.util.Optional;

public interface UserService {
    Optional<String> signUp(User user, String password) throws ServiceException;
}
