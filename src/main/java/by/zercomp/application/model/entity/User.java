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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
}
