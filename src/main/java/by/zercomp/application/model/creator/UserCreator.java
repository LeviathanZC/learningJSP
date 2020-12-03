package by.zercomp.application.model.creator;

import by.zercomp.application.model.entity.User;

import java.time.LocalDate;

public class UserCreator {

    private static class UserCreatorHolder {
        public static final UserCreator INSTANCE = new UserCreator();
    }

    private UserCreator() {
    }

    public static UserCreator getCreator() {
        return UserCreatorHolder.INSTANCE;
    }

    public User create(String id, String login, String email, String name, String surname, String birthday) {
        User newUser = new User(login, email, name, surname);
        newUser.setId(Long.parseLong(id));
        newUser.setBirth(LocalDate.parse(birthday));
        return newUser;
    }

}
