package by.zercomp.application.model.entity;

import java.time.LocalDate;

public class User extends Identifiable {

    private Role role;
    private String login;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birth;

    public User() {}

    public User(String login, String email, String firstName, String lastName, LocalDate birth) {
        this.login = login;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
    }


}
